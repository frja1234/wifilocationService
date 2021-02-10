package com.frja.wifilocation.service.impl;

import com.frja.wifilocation.dao.UserMapper;
import com.frja.wifilocation.model.User;
import com.frja.wifilocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int  register(User user) {

        return userMapper.insert(user);
    }

    @Override
    public boolean login(String userId, String userPassword) {
        User user;
        user = userMapper.selectAll(userId);
        if(user.getUserPassword().equals(userPassword)){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public int delete(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User userMessage(String userId) {

        return userMapper.selectAll(userId);
    }

}