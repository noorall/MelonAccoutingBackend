package com.nwpu.melonbookkeeping.service;

import com.nwpu.melonbookkeeping.entity.User;

import java.util.List;

public interface UserService {
    User login(String loginName, String passwordMd5);
    User getUserById(int id);
    List<User> getAllUser();
}
