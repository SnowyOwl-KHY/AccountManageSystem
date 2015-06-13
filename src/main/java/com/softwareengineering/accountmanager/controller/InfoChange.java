package com.softwareengineering.accountmanager.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;
@Controller
public class InfoChange {
    private DatabaseManager DB;
    @RequestMapping("/info_change")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String account_name = req.getParameter("account_name");
        String nickname = req.getParameter("nickname");
        String realname = req.getParameter("realname");
        String country = req.getParameter("country");
        String birthyday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String addr1 = req.getParameter("addr1");
        String text = req.getParameter("text");
        String postcode = req.getParameter("postcode");
        String gender = req.getParameter("gender");
        CommonInformation info = new CommonInformation(account_name,nickname,realname,country,birthyday,phone,addr1,text,postcode,gender);
        DB.updateCommonInformation(info);
        mv.addObject("account_name",account_name);
        mv.addObject("info",info);
        mv.setViewName("information");
        return mv;
    }
}