package com.he.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:
 */
public class UserUtil {
    //获取当前用户
    public static UsernamePasswordToken getUser(){
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) SecurityUtils.getSubject().getPrincipal();
        return usernamePasswordToken;
    }
}
