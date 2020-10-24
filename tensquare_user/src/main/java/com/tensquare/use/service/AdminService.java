package com.tensquare.use.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.use.dao.AdminDao;
import com.tensquare.use.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chenshuai
 */
@Service
public class AdminService {
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private AdminDao adminDao;

    public void add(Admin admin) {
        admin.setId(idWorker.nextId()+""); //主键值
        // 密码加密
        String newpassword = encoder.encode(admin.getPassword());
        //加密后 的密码
        admin.setPassword(newpassword);
        adminDao.save(admin);
    }

    public Admin findByLoginnameAndPassword(String loginname, String password){
        Admin admin = adminDao.findByLoginname(loginname);
        if( admin!=null && encoder.matches(password,admin.getPassword())) {
            return admin;
        }else{
            return null;
        }
    }
}
