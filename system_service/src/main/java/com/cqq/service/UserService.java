package com.cqq.service;

import com.cqq.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<UserInfo> findAll(int page, int size) throws Exception;

    public void saveUser(UserInfo userInfo);

    public UserInfo findById(int id) throws Exception;

    void delete(int id) throws Exception;

    UserInfo findByUsername(String username);
}
