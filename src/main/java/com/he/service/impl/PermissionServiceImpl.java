package com.he.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.he.config.Global;
import com.he.dao.PermissionDao;
import com.he.dao.redis.RedisDao;
import com.he.model.Permission;
import com.he.redis.RedisManager;
import com.he.service.PermissionService;
import com.he.utils.CollectionUtil;
import com.he.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RedisDao redisDao;

    private final static String MENU="menu:";

    @Override
    public String selectMenu(String username) {
        String permissionsString =redisDao.getStringSession(MENU + username);
        if (!StringUtil.isNotBlank(permissionsString)){
            HashMap<String, Object> map = new HashMap<>();
            map.put("username",username);
            List<Permission> permissions = permissionDao.selectMenu(map);
            permissionsString = JSON.toJSONString(permissions);
            redisDao.putStringAndTime(MENU+username,permissionsString, Integer.parseInt(Global.getConfig("redis.expire")));
        }
        return permissionsString;
    }
}
