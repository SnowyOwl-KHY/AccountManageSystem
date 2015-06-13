package com.softwareengineering.accountmanager.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;
@Controller
public class PayPasswordController {
    private DatabaseManager DB;
    @RequestMapping("/pay_password_change_")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String paywordOld = req.getParameter("old_password");
        String paywordNew = req.getParameter("new_password");
        String account_name = req.getParameter("account_name");
        boolean judge = DB.checkPayPassword(account_name,paywordOld);
        if(judge){
            DB.changePayPassword(account_name,paywordNew);
            mv.addObject("account_name",account_name);
            mv.setViewName("success");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("false");
        }
        return mv;
    }

    @RequestMapping("/pay_password_change")
    public ModelAndView EntryPayChange(HttpServletRequest req,HttpServletResponse resq)throws Exception{
        String account_name = req.getParameter("account_name");
        ModelAndView mv = new ModelAndView();
        mv.addObject("account_name",account_name);
        mv.setViewName("change_password");
        return mv;
    }
}