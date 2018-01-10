package com.he.dao;

import com.he.model.Permission;
import com.he.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/4
 * Description:查询权限
 */
public interface PermissionDao {

    /**
     * 查询菜单
     * @param map
     * @return
     */
    public List<Permission> selectMenu(Map map);
}
