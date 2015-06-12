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
public class PayPasswordController {
    private DatabaseManager DB;
    @RequestMapping("/pay_password_change")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String paywordOld = (String)req.getAttribute("paywordOld");
        String paywordNew = (String) req.getAttribute("paywordNew");
        String account_name = (String)req.getAttribute("account_name");
        boolean judge = DB.checkPayPassword(account_name,paywordOld);
        if(judge){
            DB.changePayPassword(account_name,paywordNew);
            mv.addObject("account_name",account_name);
            mv.setViewName("payword_success");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("payword_false");
        }
        return mv;
    }
}