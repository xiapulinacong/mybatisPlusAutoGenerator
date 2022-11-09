package com.lin.test.controller;


import com.alibaba.fastjson.JSON;
import com.lin.test.entity.User;
import com.lin.test.service.UserService;
import com.lin.test.utils.AopLogAspect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 啊聪
 * @since 2022-10-08
 */
@Api("测试接口")
@RestController
@RequestMapping(value="/test/user")
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Resource
    UserService userService;
    @ApiOperation("获取用户")// 为每个handler添加方法功能描述
    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public String getuser(@ApiParam(value = "id") @RequestParam(name="id") long id){
        User user=userService.getById(id);
        return JSON.toJSONString(user);
    }
    @GetMapping(value="/getAllUser")
    public String getAllUser(){
        List<User> users=userService.getAllUser();
        return JSON.toJSONString(users);
    }
    @RequestMapping(value="/getUserByUserName", method = RequestMethod.GET)
    public String getUserByUserName(@ApiParam(value = "username") @RequestParam(name="username") String username){
        User user=userService.getUserByUserName(username);
        logger.info("获取用户信息--getUserByUserName");

        return JSON.toJSONString(user);
    }
    @RequestMapping(value = "/batchAddUser")
    public String batchAddUser(){
        int tamp=190732;
        for(int i=1;i<800;i++){
            List<User> users=new ArrayList<User>() ;
        for(int a=1;a<=10000;a++){
                User user=new User();
                user.setId(tamp+a);
                user.setUsername("test"+tamp+a);
                user.setPassword("123456");
                user.setDeleted(0);
                users.add(user);
            }
            tamp+=10000;
            //userService.save(user);
            userService.saveBatch(users);
        }
        return "oK";
    }

}

