package com.tensquare.use.controller;

import com.tensquare.use.pojo.User;
import com.tensquare.use.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenshuai
 */
@RestController
@RequestMapping("/use")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendsms(@PathVariable String mobile) {
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功");
    }

    @RequestMapping(value="/register/{code}",method=RequestMethod.POST)
    public Result register(@RequestBody User user , @PathVariable String code){
        userService.add(user,code);
        return new Result(true,StatusCode.OK,"注册成功");
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public Result login(String mobile,String password){
        User user = userService.findByMobileAndPassword(mobile,password);
        if(user!=null){ return new Result(true,StatusCode.OK,"登陆成功");
        }else{
            return new Result(false,StatusCode.LOGIN_ERROR,"用户名或密码错 误");
        }
    }
}
