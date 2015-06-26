package com.softwareengineering.accountmanager.controller;

/**
 * Created by 易儒 on 2015/6/12.
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
public class LogupController {
    private DatabaseManager DB;
    @RequestMapping("/signup")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();// 建立新的页面
        String account_name = req.getParameter("account_name");//得到用户名
        if(account_name == null)
        {
            mv.setViewName("signup");
            mv.addObject("judge",true);
            return mv;
        }
        ///////////////////////////////////////////////////////
        //添加邮件
        //////////////////////////////////////////////////////
        String password = req.getParameter("password");//得到密码
        String registerId = "" + Math.random() * Math.random();

        DB =new DatabaseManager();//数据库对象
        Boolean exist = DB.existUser(account_name);

        if(!exist) {
            DB.addUser(account_name, password, registerId);
            String from = "3120100759@zju.edu.cn";
            // 假设您是从本地主机发送电子邮件
            String host = "smtp.zju.edu.cn";
            // 获取系统的属性
            Properties properties = System.getProperties();
            // 设置邮件服务器
            properties.setProperty("mail.transport.protocol", "smtp");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.user", "3120100759");
            properties.setProperty("mail.password", "060979");
            String url = "http://localhost:8080/mail_back?registerId=" + registerId + "&account_name="+account_name;
            Session session = Session.getInstance(properties,
                    //返回验证信息的内部类
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("3120100759@zju.edu.cn", "060979");
                        }
                    }
            );
            session.setDebug(true);
            try{
                // 创建一个默认的 MimeMessage 对象
                MimeMessage message = new MimeMessage(session);
                // 设置 From: header field of the header.
                message.setFrom(new InternetAddress(from));
                // 设置 To: header field of the header.
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(account_name));
                // 设置 Subject: header field
                message.setSubject("identity for logup");
                message.setSentDate(new Date());
                // 现在设置实际消息
                message.setContent("<p>click<a href=" + url + ">" + url + "</a>to sign up</p>", "text/html");
                // 发送消息
                Transport.send(message);
            }catch (MessagingException mex) {
                mex.printStackTrace();
            }
            mv.setViewName("check_email");
        }else{
            mv.addObject("account_name",account_name);
            mv.addObject("judge",false);
            mv.setViewName("signup");
        }
        return mv;
    }
}