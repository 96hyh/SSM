package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User queryUserById(@Param("id") Long id);

    List<User> queryUserList();

    int addUser(User user);

    void deleteUser(@Param("id") Long id);
}
