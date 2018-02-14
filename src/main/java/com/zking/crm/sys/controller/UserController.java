package com.zking.crm.sys.controller;

import com.zking.crm.sys.biz.IUserBiz;
import com.zking.crm.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController{

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request) {
        User u = userBiz.load(user);
        if (u != null) {
            if(u.getUsrPassword().equals(user.getUsrPassword())){
                request.getSession().setAttribute("usr",u);
                return "succen";
            }
            return "1";
        }
        return "0";
    }
}
