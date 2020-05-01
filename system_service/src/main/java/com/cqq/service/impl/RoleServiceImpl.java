package com.cqq.service.impl;

import com.cqq.dao.RoleDao;
import com.cqq.domain.Role;
import com.cqq.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRoleToUser(int userId, int roleId) {
        roleDao.addRoleToUser(userId,roleId);
    }

    @Override
    public List<Role> findOtherRole(int userId) {
        return roleDao.findOtherRole(userId);
    }

    @Override
    public List<Role> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }
}
