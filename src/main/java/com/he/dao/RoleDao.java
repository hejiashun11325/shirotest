package com.he.dao;

import com.he.model.Role;

import java.util.List;
import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/3
 * Description:
 */
public interface RoleDao {
    /**
     * 获取角色
     * @param map
     * @return
     */
    public List<Role> selectRoles(Map map);
}
