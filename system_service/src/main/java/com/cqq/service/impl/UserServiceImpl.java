package com.cqq.service.impl;

import com.cqq.dao.RoleDao;
import com.cqq.dao.UserDao;
import com.cqq.domain.Role;
import com.cqq.domain.UserInfo;
import com.cqq.service.UserService;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try{
            userInfo = userDao.findByUsername(username);
            System.out.println(userInfo.getRoles());
            List<Role> roleByUserId = roleDao.findRoleByUserId(1);
            System.out.println(roleByUserId);
        }catch (Exception e){
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);

        return userDao.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void delete(int id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
