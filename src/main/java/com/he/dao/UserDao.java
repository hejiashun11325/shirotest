package com.he.dao;

import com.he.model.User;

import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/3
 * Description:查询用户信息
 */
public interface UserDao {
    /**
     * 查询用户
     * @param map
     * @return
     */
    public User selectUser(Map map);

    public User getUser(Map map);
}
