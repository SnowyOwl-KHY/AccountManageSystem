package com.softwareengineering.accountmanager.controller;

/**
 * Created by 易儒 on 2015/6/12.
 */
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import com.softwareengineering.accountmanager.model.DatabaseManager;
        import com.softwareengineering.accountmanager.model.data.CommonInformation;
        import com.softwareengineering.accountmanager.model.data.SecurityInformation;
        import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;
        import org.springframework.stereotype.*;
@Controller
public class PasswordController {
    private DatabaseManager DB;
    @RequestMapping("/password_change_")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();// 建立新的页面
        String account_name = req.getParameter("account_name");//得到用户名
        String old_password = req.getParameter("old_password");//得到就得密码
        String new_password = req.getParameter("new_password");//得到新密码
        DB =new DatabaseManager();//数据库对象
        boolean judge = DB.checkPassword(account_name,old_password);//判断旧密码是否正确
        if(judge){
            DB.changePassword(account_name,new_password);
            mv.addObject("account_name",account_name);
            mv.setViewName("success");
        }else{
            mv.addObject("account_name",account_name);
            mv.setViewName("fail");
        }
        return mv;
    }
    @RequestMapping("password_change")
    public ModelAndView EntryPasswordChange(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        ModelAndView mv = new ModelAndView();
        String account_name = req.getParameter("account_name");
        mv.addObject("account_name",account_name);
        mv.setViewName("password");
        return mv;
    }
}