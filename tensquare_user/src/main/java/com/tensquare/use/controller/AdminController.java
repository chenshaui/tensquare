package com.tensquare.use.controller;

import com.tensquare.use.pojo.Admin;
import com.tensquare.use.pojo.StatusCode;
import com.tensquare.use.service.AdminService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
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

    @Autowired
    private JwtUtil jwtUtil;

    /**
     *
     * 用户登陆
     * @param loginMap 登录信息
     * @return entity.Result
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap){
        Admin admin = adminService.findByLoginnameAndPassword(loginMap.get("loginname"), loginMap.get("password"));
        if (admin != null) {
            //生成token
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            Map map = new HashMap();
            map.put("token", token);
            map.put("name", admin.getLoginname());
            //登陆名
            return new Result(true, StatusCode.OK,"登陆成功", map);
        } else {
            return new Result(false, StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }
}
