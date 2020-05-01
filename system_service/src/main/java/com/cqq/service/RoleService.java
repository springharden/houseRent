package com.cqq.service;

import com.cqq.domain.Role;

import java.util.List;

public interface RoleService {
    void addRoleToUser(int userId,int roleId);

    List<Role> findOtherRole(int userId);

    List<Role> findAll(int page, int size) throws Exception;
}
