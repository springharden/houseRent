package com.cqq.dao;

import com.cqq.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDao {


    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<UserInfo> findAll();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id" ),
            @Result(property = "username",column = "username" ),
            @Result(property = "email",column = "email" ),
            @Result(property = "phoneNum",column = "phoneNum" ),
            @Result(property = "userType",column = "userType" ),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.cqq.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username);

    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into user(id,username,password,email,phoneNum,userType) values(null,#{username},#{password},#{email},#{phoneNum},#{userType})")
    void saveUser(UserInfo userInfo);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id" ),
            @Result(property = "username",column = "username" ),
            @Result(property = "email",column = "email" ),
            @Result(property = "phoneNum",column = "phoneNum" ),
            @Result(property = "userType",column = "userType" ),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.cqq.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id) throws Exception;

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(int id);

}
