package com.he.controller;

import com.alibaba.fastjson.JSONArray;
import com.he.model.Permission;
import com.he.service.PermissionService;
import com.he.utils.UserUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author: hejiashun
 * @Date: 2018/1/10
 * Description:
 */
@RequestMapping("menu")
@Controller
public class MenuController {

    @Autowired
    private PermissionService permissionService;
    /**
     * 获取菜单栏
     * @param model
     * @return
     */
    @RequestMapping(value = "/getMenu")
    public String getMenu(Model model){
        try{
            UsernamePasswordToken user = UserUtil.getUser();
            String menu = permissionService.selectMenu(user.getUsername());
            List<Permission> permissions = JSONArray.parseArray(menu, Permission.class);
            model.addAttribute("menu",permissions);
            return "/login/welcome";
        }catch (Exception e){
            e.printStackTrace();
            return "/login/error";
        }
    }
}
