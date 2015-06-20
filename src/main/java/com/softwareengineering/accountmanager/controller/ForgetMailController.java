package com.softwareengineering.accountmanager.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Random;

@Controller
public class ForgetMailController {
    private DatabaseManager DB;
    @RequestMapping("/forget_mail_back")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();
        DB =new DatabaseManager();
        String account_name = req.getParameter("account_name");
        String registerId = req.getParameter("registerId");
        Random random = new Random();
        String password = String.valueOf(random.nextInt(899999)+100000);
        boolean judge = DB.resetPassword(account_name, registerId,password);
        if(judge){
            mv.addObject(password,"password");
            mv.addObject(account_name,"account_name");
            mv.setViewName("forget_password_");
        } else{
            mv.addObject("account_name",account_name);
            mv.setViewName("mail_error");
        }
        return mv;
    }
}