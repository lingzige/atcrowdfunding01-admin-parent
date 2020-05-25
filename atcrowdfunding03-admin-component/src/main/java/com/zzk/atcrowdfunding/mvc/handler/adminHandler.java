package com.zzk.atcrowdfunding.mvc.handler;


import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class adminHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session){
        // 强制session失效
        session.invalidate();

        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, HttpSession session){
        // 将查询到的结果存入到session域中
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        return "redirect:/admin/to/main/page.html";
    }
}
