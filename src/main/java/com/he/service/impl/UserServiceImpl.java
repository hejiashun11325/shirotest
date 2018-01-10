package com.he.service.impl;

import com.he.dao.UserDao;
import com.he.model.User;
import com.he.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/3
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUser(Map map) {
        return userDao.selectUser(map);
    }

    @Override
    public User getUser(Map map) {
        return userDao.getUser(map);
    }
}
