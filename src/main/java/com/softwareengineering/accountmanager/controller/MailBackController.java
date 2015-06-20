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

@Controller
public class MailBackController {
    private DatabaseManager DB;
    @RequestMapping("/mail_back")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();
        DB =new DatabaseManager();
        String account_name = req.getParameter("account_name");
        String registerId = req.getParameter("registerId");
        boolean judge = DB.checkRegisterId(account_name,registerId);
        if(judge){
            DB.activateUser(account_name,registerId);
            double balance = 0;
            List<PurchaseRecord> record = DB.queryPurchaseRecordByAccountName(account_name);
            mv.addObject("balance",balance);
            mv.addObject("record",record);
            mv.addObject("account_name",account_name);
            mv.setViewName("main");
        } else{
            mv.addObject("account_name",account_name);
            mv.setViewName("mail_error");
        }
        return mv;
    }
}