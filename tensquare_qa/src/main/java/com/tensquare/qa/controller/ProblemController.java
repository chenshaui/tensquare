package com.tensquare.qa.controller;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenshuai
 */
@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 根据标签ID查询最新问题列表
     * @param labelid
     * @return
     */
    @RequestMapping(value="/newlist/{labelid}/{page}/{size}",method= RequestMethod.GET)
    public Result findNewListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size ){
        Page<Problem> pageList = problemService.findNewListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param labelid
     * @return
     */
    @RequestMapping(value="/hotlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result findHotListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size ){
        Page<Problem> pageList = problemService.findHotListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }


    /**
     * 根据标签ID查询等待回答列表
     * @param labelid
     * @return
     */
    @RequestMapping(value="/waitlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result findWaitListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size ){
        Page<Problem> pageList = problemService.findWaitListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 发布问题
     * @param problem 问题对象
     * @return entity.Result
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Problem problem ){
        Claims claims = (Claims) request.getAttribute("user_claims");
        if(claims==null){
            return new Result(false,StatusCode.ACCESS_ERROR,"无权访问");
        }
        problem.setUserid(claims.getId());
        problemService.add(problem);
        return new Result(true,StatusCode.OK,"增加成功");
    }
}
