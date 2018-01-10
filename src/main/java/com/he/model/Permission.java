package com.he.model;

import java.util.List;

/**
 * @author: hejiashun
 * @Date: 2018/1/3
 * Description:
 */
public class Permission {
    /**
     * id
     */
    private String id;
    /**
     * 编号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 链接
     */
    private String url;
    /**
     * 权限
     */
    private String permission;
    /**
     * 种类('0'菜单，'1'权限，'2'父节点)
     */
    private String type;
    /**
     * 子节点
     */
    private List<Permission> childrenNode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Permission> getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(List<Permission> childrenNode) {
        this.childrenNode = childrenNode;
    }
}
