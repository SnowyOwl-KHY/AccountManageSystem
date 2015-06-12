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
        CommonInformation info = (CommonInformation)req.getAttribute("info");
        String account_name = (String)req.getAttribute("account_name");
        DB.updateCommonInformation(info);
        mv.addObject("account_name",account_name);
        mv.setViewName("info_success");
        return mv;
    }
}