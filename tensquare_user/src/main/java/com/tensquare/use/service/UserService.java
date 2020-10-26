package com.tensquare.use.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.use.dao.UserDao;
import com.tensquare.use.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenshuai
 */
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private UserDao userDao;

    public void sendSms(String mobile){
        //1.生成6位短信验证码
        Random random = new Random();
        // 最大数
        int max = 999999;
        // 最小数
        int min = 100000;
        // 随机生成
        int code = random.nextInt(max);
        if (code < min) {
            code = code + min;
        }
        System.out.println(mobile + "收到验证码是：" + code);
        // 2.将验证码放入redis
        // 五分钟过期
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "" ,5, TimeUnit.MINUTES);
        // 3.将验证码和手机号发动到rabbitMQ中
        Map<String,String> map = new HashMap();
        map.put("mobile",mobile);
        map.put("code",code+"");
        rabbitTemplate.convertAndSend("sms", map);
    }

    public void add(User user, String code) {
        //判断验证码是否正确
        String syscode = (String)redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        // 提取系统正确的验证码
        if(syscode==null){
            throw new RuntimeException("请点击获取短信验证码");
        }
        if(!syscode.equals(code)){
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId(idWorker.nextId()+"" );
        //关注数
        user.setFollowcount(0);
        //粉丝数
        user.setFanscount(0);
        //在线时长
        user.setOnline(0L);
        //注册日期
        user.setRegdate(new Date());
        //更新日期
        user.setUpdatedate(new Date());
        //最后登陆日期
        user.setLastdate(new Date());
        //加密后的 密码
        String newpassword = encoder.encode(user.getPassword());
        user.setPassword(newpassword);
        userDao.save(user);
    }

    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if(user!=null && encoder.matches(password,user.getPassword())){
            return user;
        }else{
            return null;
        }
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
