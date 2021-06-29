package com.lovecoding.service;

import com.lovecoding.pojo.User;

import java.util.Map;

public interface UserService {
    int register(Map<String, String[]> parameterMap);

    User login(String username, String password);
}
