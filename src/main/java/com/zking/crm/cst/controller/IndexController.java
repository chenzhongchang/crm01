package com.zking.crm.cst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index/toIndex")
    public String toIndex(){

        System.out.println("------------------------------------------------------------");
        return "index";
    }

}
