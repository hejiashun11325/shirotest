package com.he.model;

import java.util.List;

/**
 * @author: hejiashun
 * @Date: 2018/1/3
 * Description:角色
 */
public class Role {
    /**
     * 角色id
     */
    private String roleId;
    private String name;
    private String code;
    private List<Permission> permissions;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
