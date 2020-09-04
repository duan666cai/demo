package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values(#{username},#{password})")
    void adduser(User user);  //定义的抽象方法，通过对应的注解实现@insert
    @Select("select * from user where username=#{username}")
    User getuser(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);
    @Delete("delete from user where username=#{username}")
    void deleteuser(String username);
    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username,String password);
}
