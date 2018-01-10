package com.he.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.he.model.Permission;
import com.he.model.User;
import com.he.service.PermissionService;
import com.he.service.UserService;
import com.he.utils.MD5;
import com.he.utils.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: hejiashun
 * @Date: 2017/12/7
 * Description:
 */
@Controller
@RequestMapping("/login")
public class Login {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return  "/login/login";
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(User user,Model model){
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), MD5.getHexMD5(user.getPassword()));
            Subject subject = SecurityUtils.getSubject();
            usernamePasswordToken.setRememberMe(true);
            subject.login(usernamePasswordToken);
            return "redirect:/menu/getMenu";
        }catch (Exception e){
            model.addAttribute("errorMsg",e.getMessage());
            return "/login/login";
        }
    }

    /**
     * 登出
     * @param model
     * @return
     */
    @RequestMapping(value = "/logOut")
    public String logOut(Model model){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception e){
            model.addAttribute("errorMsg",e.getMessage());
        }
        return "/login/login";
    }

}
