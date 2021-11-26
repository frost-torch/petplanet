package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.User;
import com.petplanet.backend.vo.UserVo;

import java.util.Map;

public interface UserDao {

    Map<String, Object> addUser(User user);
    UserVo queryUser(String email);

}
