package com.cqq.dao;

import com.cqq.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from user_role where userId = #{userId})")
    public List<Role> findRoleByUserId(int userId) throws Exception;

    /**
     * 为用户添加角色，底层操作user_role表格，插入一条数据
     * @param userId
     * @param roleId
     */
    @Insert("insert into user_role(id,userId,roleId) values(null,#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);

    /**
     * 根据用户id查询用户没有的所有角色
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from user_role where userId = #{userId})")
    List<Role> findOtherRole(int userId);

    @Select("select * from role ")
    List<Role> findAll() throws Exception;
}
