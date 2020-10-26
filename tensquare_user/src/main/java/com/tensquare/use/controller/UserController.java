package com.tensquare.use.controller;

import com.tensquare.use.pojo.User;
import com.tensquare.use.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshuai
 */
@RestController
@RequestMapping("/use")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value="/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendsms (@PathVariable String mobile) {
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功");
    }

    @RequestMapping(value="/register/{code}", method=RequestMethod.POST)
    public Result register(@RequestBody User user , @PathVariable String code) {
        userService.add(user,code);
        return new Result(true,StatusCode.OK,"注册成功");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap) {
        User user = userService.findByMobileAndPassword(loginMap.get("mobile"),loginMap.get(" password"));
        if(user!=null){
            String token = jwtUtil.createJWT(user.getId(), user.getNickname(), "user");
            Map map = new HashMap<>();
            map.put("token", token);
            // 昵称
            map.put("name", user.getNickname());
            // 头像
            map.put("avatar", user.getAvatar());
            return new Result(true,StatusCode.OK,"登陆成功", map);
        } else {
            return new Result(false,StatusCode.LOGIN_ERROR,"用户名或密码错误");
        }
    }

    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        String authHeader = request.getHeader("Authorization");
        //获取头信 息
        if(authHeader==null){
            return new Result(false,StatusCode.ACCESS_ERROR,"权限不足");
        }
        if(!authHeader.startsWith("Bearer ")){
            return new Result(false,StatusCode.ACCESS_ERROR,"权限不足");
        }
        String token=authHeader.substring(7);
        //提取token
        Claims claims = jwtUtil.parseJWT(token);
        if(claims==null){
            return new Result(false,StatusCode.ACCESS_ERROR,"权限不足");
        }
        if(!"admin".equals(claims.get("roles"))){
            return new Result(false,StatusCode.ACCESS_ERROR,"权限不足");
        }
        userService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /*@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        Claims claims=(Claims) request.getAttribute("admin_claims");
        if(claims==null){
            return new Result(true,StatusCode.ACCESS_ERROR,"无权访问");
        }
        userService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }*/
}
