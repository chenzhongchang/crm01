package com.zking.crm.sal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.crm.sal.biz.IChanceBiz;
import com.zking.crm.sal.model.Chance;
import com.zking.crm.sys.biz.IUserBiz;
import com.zking.crm.sys.model.User;
import com.zking.util.ResponseData;
import com.zking.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ChanceController {
    private Integer page;
    private Integer rows;

    @Autowired
    private IChanceBiz chanceBiz;

    @Autowired
    private IUserBiz userBiz;
    private User user = new User();

    @RequestMapping("/chance/toAddChance")
    @ResponseBody
    public List<User> toAddChance(@ModelAttribute Chance chance){
        List<User> listUser = userBiz.list(user);
        return listUser;
    }

    @RequestMapping("/toListChance")
    public String toListChance(@ModelAttribute Chance chance){
        return "system/listChance";
    }

    @RequestMapping("/chance/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request, HttpServletResponse response){
        String chcCustName = request.getParameter("chcCustName");
        String page =request.getParameter("page");
        String rows =request.getParameter("rows");
        Chance chance = new Chance();
        chance.setChcCustName(chcCustName);
        if (StringUtils.isNotBlank(page)) {
            this.page = Integer.parseInt(page);
        }
        if (StringUtils.isNotBlank(rows)) {
            this.rows = Integer.parseInt(rows);
        }
        PageHelper.startPage(this.page,this.rows);

        List<Chance> listChance = chanceBiz.list(chance);
        PageInfo<Chance> p = new PageInfo<Chance>(listChance);
        for (Chance c : listChance) {
            c.setDateName(c.getChcCreateDate());
        }
        ResponseData responseData = new ResponseData();
        responseData.setRows(listChance);
        responseData.setTotal((int) p.getTotal());
        response.setContentType("text/plain;charset=utf-8");
        return responseData;
    }

}
