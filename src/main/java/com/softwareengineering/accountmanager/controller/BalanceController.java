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
    @RequestMapping("/balance_update")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String account_name = (String)req.getAttribute("account_name");
        String payword = (String)req.getAttribute("payword");
        Double balance = Double.parseDouble((String)req.getAttribute("balance"));
        boolean judge = DB.checkPayPassword(account_name,payword);
        if(judge){
            DB.updateBalance(account_name,balance);
            mv.addObject("account_name",account_name);
            mv.setViewName("balance_success");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("balance_failed");
        }
        return mv;
    }
}