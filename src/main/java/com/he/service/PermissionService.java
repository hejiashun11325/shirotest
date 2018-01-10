package com.he.service;

import com.he.model.Permission;

import java.util.List;
import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:
 */
public interface PermissionService {
    /**
     * 查询菜单
     * @param username
     * @return
     */
    public String selectMenu(String username);
}
