package com.softwareengineering.accountmanager.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;

import java.util.Date;

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        mv.addObject("blabla", "blabla");
        PurchaseRecord[] p = new PurchaseRecord[10];
        p[0] = new PurchaseRecord("ACCOUNT1001",new Date(10000001),99999990,400);
        p[1] = new PurchaseRecord("ACCOUNT1001",new Date(10000002),99999991,200);
        p[2] = new PurchaseRecord("ACCOUNT1001",new Date(10000003),99999992,330);
        p[3] = new PurchaseRecord("ACCOUNT1001",new Date(10000004),99999993,304);
        p[4] = new PurchaseRecord("ACCOUNT1001",new Date(10000005),99999994,100);
        p[5] = new PurchaseRecord("ACCOUNT1001",new Date(10000006),99999995,90);
        p[6] = new PurchaseRecord("ACCOUNT1001",new Date(10000007),99999996,3000);
        p[7] = new PurchaseRecord("ACCOUNT1001",new Date(10000008),99999997,304);
        p[8] = new PurchaseRecord("ACCOUNT1001",new Date(10000009),99999998,400);
        p[9] = new PurchaseRecord("ACCOUNT1001",new Date(10000000),99999999,60);
        mv.addObject("url", req.getRequestURL());
        mv.addObject("ACCOUNT","ACCOUNT10001");
        mv.addObject("Purchase",p);
        mv.addObject("MONEYB",9324);
        mv.addObject("MONEYS",32);
        mv.setViewName("main");
        return mv;
    }
    @RequestMapping("/main2")
    public ModelAndView handleRequest1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        mv.addObject("blabla", "blabla");
        PurchaseRecord[] p = new PurchaseRecord[4];
        p[0] = new PurchaseRecord("ACCOUNT1001",new Date(10000001),99999990,400);
        p[1] = new PurchaseRecord("ACCOUNT1001",new Date(10000002),99999991,200);
        p[2] = new PurchaseRecord("ACCOUNT1001",new Date(10000003),99999992,330);
        p[3] = new PurchaseRecord("ACCOUNT1001",new Date(10000004),99999993,304);
        mv.addObject("url", req.getRequestURL());
        mv.addObject("ACCOUNT","ACCOUNT10001");
        mv.addObject("Purchase",p);
        mv.addObject("MONEYB",9324);
        mv.addObject("MONEYS",req.getParameter("MONEYS"));
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/info")
    public ModelAndView handleRequest2(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ACCOUNT","ACCOUNT10001");
        mv.addObject("address","Room 0503, Unit 1, Building 3, No.453, Beicang Road, Congtai District, Handan City");
        mv.addObject("name","doris");
        mv.addObject("nickname","fatfat");
        mv.addObject("gender","else");
        mv.addObject("postcode","325000");
        mv.addObject("phone","1887774443");
        mv.addObject("text","I am the most powerful monster in the world. I exist in the castle game, do you wanna play?");
        mv.addObject("birthday","04/05/1998");
        mv.addObject("country","Korean");
        mv.setViewName("information");
        return mv;
    }

    @RequestMapping("/info2")
    public ModelAndView handleRequest3(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ACCOUNT","ACCOUNT10001");
        mv.addObject("address","Room 0503, Unit 1, Building 3, No.453, Beicang Road, Congtai District, Handan City");
        mv.addObject("name","doris");
        mv.addObject("nickname","fatfat");
        mv.addObject("gender","else");
        mv.addObject("postcode","325000");
        mv.addObject("phone","1887774443");
        mv.addObject("text","I am the most powerful monster in the world. I exist in the castle game, do you wanna play?");
        mv.addObject("birthday",req.getParameter("birthday"));
        mv.addObject("country",req.getParameter("country"));
        mv.setViewName("information");
        return mv;
    }
}