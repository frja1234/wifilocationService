package com.frja.wifilocation.service;

import com.frja.wifilocation.model.User;


public interface UserService {
    //注册
    public int register(User user);
    //登录
    public boolean login(String userId,String userPassword);
    //注销
    public int delete(String userId);
    //查看用户信息
    public User userMessage(String userId);
}
