package com.softwareengineering.accountmanager.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;
@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World");
        mv.addObject("blabla", "blabla");
        SecurityInformation[] s = new SecurityInformation[2];
        s[0] = new SecurityInformation("a", "b", "c");
        s[1] = new SecurityInformation("e", "f", "g");
        mv.addObject("complextype", s);
        mv.addObject("url", req.getRequestURL());
        mv.setViewName("hello");
        return mv;
    }
}