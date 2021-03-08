package com.frja.wifilocation.controller;

import com.frja.wifilocation.model.User;
import com.frja.wifilocation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 Controller
 *
 * @author v_jingwen
 * @date 2020年9月9日 下午15:18:08
 *
 */
@RestController
@RequestMapping(value = "/wifilocation/user", produces = "application/json;charset=UTF-8")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping(value = "/login")
    public Map<String, Object> login(String userId,String userPassword){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            boolean flag = userService.login(userId,userPassword);
            System.out.println(" vfjd");
            if(flag){
                resultMap.put("data",userId);
                resultMap.put("code", "200");
                resultMap.put("msg", "登录成功");
            }else{
                resultMap.put("data",userId);
                resultMap.put("code", "500");
                resultMap.put("msg", "登录失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "操作失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "操作失败" + e.getMessage());
        }
        return resultMap;
    }

    /***
     * 用户注册
     * @param user
     */
    @RequestMapping(value = "/register")
    public Map<String,Object> insert(User user){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            System.out.println(user.toString());
            int id = userService.register(user);
            resultMap.put("data",id);// 返回记录主键id
            resultMap.put("code","200");
            resultMap.put("msg","注册成功");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code","500");
            resultMap.put("msg","注册失败"+e.getMessage());
        }
        return resultMap;
    }
    /***
     * 根据ID查询用户信息
     * @param id
     */
    @RequestMapping(value = "/userMessage")
    public Map<String, Object> register(String id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User user = userService.userMessage(id);
            System.out.println(" vfjd");
            resultMap.put("data", user);
            resultMap.put("code", "200");
            resultMap.put("msg", "获取成功");
        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "获取失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "获取失败" + e.getMessage());
        }
        return resultMap;
    }

}
