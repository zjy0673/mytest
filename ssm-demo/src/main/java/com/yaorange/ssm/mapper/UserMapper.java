package com.yaorange.ssm.mapper;

import com.yaorange.ssm.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    void insertUser(User user);

    void updateUser(User user);

    void deleteById(Integer id);
}
