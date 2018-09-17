package cn.itcast.service;

import cn.itcast.pojo.User;

import java.util.List;


public interface IUserService {
    List<User> queryUserList();

    int addUsers(User user);

    Boolean saveUser(User user);

    void deleteUser(Long id);
}
