package com.tensquare.use.controller;

import com.tensquare.use.pojo.Admin;
import com.tensquare.use.pojo.StatusCode;
import com.tensquare.use.service.AdminService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author chenshuai
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap){
        Admin admin = adminService.findByLoginnameAndPassword(loginMap.get("loginname"), loginMap.get("password"));
        if(admin!=null){
            return new Result(true, StatusCode.OK,"登陆成功");
        }else{
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错 误");
        }
    }
}
