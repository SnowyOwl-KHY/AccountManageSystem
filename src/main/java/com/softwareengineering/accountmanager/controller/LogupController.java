package com.softwareengineering.accountmanager.controller;

/**
 * Created by 易儒 on 2015/6/12.
 */
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
public class LogupController {
    private DatabaseManager DB;
    @RequestMapping("/signup")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();// 建立新的页面
        String account_name = req.getParameter("account_name");//得到用户名
        String password = req.getParameter("password");//得到密码
        String pay_password = new String(password);
        if(account_name == null)
        {
            mv.setViewName("signup");
            return mv;
        }
        DB =new DatabaseManager();//数据库对象
        Boolean exist = DB.existUser(account_name);
        if(!exist) {
            DB.addUser(account_name,password,pay_password);
            Double balance = DB.queryBalance(account_name);
            List<PurchaseRecord> record = DB.queryPurchaseRecordByAccountName(account_name);
            mv.addObject("balance",balance);
            mv.addObject("record",record);
            mv.addObject("account_name",account_name);
            mv.setViewName("main");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("logup_error");
        }
        return mv;
    }
}