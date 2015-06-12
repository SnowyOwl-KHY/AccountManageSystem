package com.softwareengineering.accountmanager.controller;

/**
 * Created by 易儒 on 2015/6/12.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;
@Controller
public class LoginController {
    private DatabaseManager DB;
    @RequestMapping("/login")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();// 建立新的页面
        String account_name = (String)req.getAttribute("account_name");//得到用户名
        String password = (String)req.getAttribute("password");//得到密码
        DB =new DatabaseManager();//数据库对象
        boolean judgeAccount;//判断密码和用户名是否符合
        judgeAccount = DB.checkPassword(account_name, password);
        if (judgeAccount) {
            CommonInformation s = DB.queryCommonInformation(account_name);
            mv.addObject("account_name",account_name);
            mv.addObject("information",s);
            mv.addObject("url",req.getRequestURL());
            mv.setViewName("main");
            return mv;
        }
        else{
            mv.addObject("account_name",account_name);
            mv.setViewName("login error");
            return  mv;
        }
    }
}