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
public class BalanceController {
    private DatabaseManager DB;
    @RequestMapping("/recharge_")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String account_name = req.getParameter("account_name");
        String payword = req.getParameter("password");
        Double balance = Double.parseDouble(req.getParameter("money"));
        boolean judge = DB.checkPayPassword(account_name,payword);
        if(judge && balance > 0){
            DB.recharge(account_name,balance);
            mv.addObject("account_name",account_name);
            mv.setViewName("success");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("fail");
        }
        return mv;
    }

    @RequestMapping("/recharge")
    public ModelAndView EntryBalance(HttpServletRequest req,HttpServletResponse resp)throws Exception {
        ModelAndView mv = new ModelAndView();
        String account_name = req.getParameter("account_name");
        mv.addObject("account_name",account_name);
        mv.setViewName("recharge");
        return mv;
    }
}