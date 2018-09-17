package cn.itcast.service.impl;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//装配到容器
@Service
public class UserServiceImpl implements IUserService {

    //注入mapper
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public int addUsers(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Boolean saveUser(User user) {
        int i = userMapper.addUser(user);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}
