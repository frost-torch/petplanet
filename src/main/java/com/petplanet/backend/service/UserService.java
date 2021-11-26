package com.petplanet.backend.service;

import com.petplanet.backend.dao.UserDao;
import com.petplanet.backend.pojo.User;
import com.petplanet.backend.util.WebStatusUtil;
import com.petplanet.backend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @SuppressWarnings("all")
    @Autowired
    UserDao userDao;

    public Map<String, Object> addUser(User user) {
        return userDao.addUser(user);
    }

    public Map<String, Object> queryUser(String email) {

        UserVo resultVo = userDao.queryUser(email);
        if (null == resultVo) {
            return WebStatusUtil.httpError("无相关信息");
        }

        Map<String, Object> result = WebStatusUtil.httpOk("响应成功！");
        result.put("user", resultVo);
        return result;
    }

}
