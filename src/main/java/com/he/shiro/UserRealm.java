package com.he.shiro;

import com.he.model.Permission;
import com.he.model.Role;
import com.he.model.User;
import com.he.service.RoleService;
import com.he.service.UserService;
import com.he.utils.StringUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author: hejiashun
 * @Date: 2017/11/22
 * Description:
 */
@Service
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        User user = userService.selectUser(map);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role:user.getRoles()){
            info.addRole(role.getName());
            for (Permission permission:role.getPermissions()){
                if(StringUtil.isNotBlank(permission.getPermission())){
                    info.addStringPermission(permission.getPermission());
                }
            }
        }
        info.addStringPermission("user");
        return info;
    }

    /**
     * 登陆授权
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        //获取用户名
        String username = token1.getUsername();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        User user = userService.selectUser(map);
        //判断账号信息，自定义报错
        if (user==null){
            throw new AuthenticationException("该账号不存在");
        }
        if(!user.getPassword().equals(new String(token1.getPassword()))){
            throw new AuthenticationException("密码错误");
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usernamePasswordToken,user.getPassword(),getName());
        return simpleAuthenticationInfo;
    }

}
