package com.frja.wifilocation.dao;

import com.frja.wifilocation.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.awt.*;


@Component
public interface UserMapper {
    //插入用户信息
    @Insert("insert into tbl_user(user_id,user_name,user_authority,user_password,create_date) values (#{userId},#{userName},#{userAuthority},#{userPassword},#{createTime})")
    int insert(User user);
    //修改用户信息
    int update(User user);
    //查询用户信息
    @Select("select * from tbl_user where user_id=#{id}")
    @ResultType(User.class)
    User selectAll(String id);
    //删除用户信息
    @Delete("delete from tbl_user where user_id=#{id}")
    int deleteByPrimaryKey(String userId);

    int insertSelective(User record);
    //获取所有用户信息
    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}