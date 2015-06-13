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
public class InfoController {
    private DatabaseManager DB;
    @RequestMapping("/person_info")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();
        DB =new DatabaseManager();
        String account_name = req.getParameter("account_name");
        CommonInformation info = DB.queryCommonInformation(account_name);
        mv.addObject("info",info);
        mv.addObject("account_name",account_name);
        mv.setViewName("person_info");
        return mv;
    }
}