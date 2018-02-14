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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @RequestMapping("/toListChance")
    public String toListChance(){
        return "system/sal/listChance";
    }

    @RequestMapping("chance/toEload")
    public String toEload(Chance chance,Model model){
        Chance c = chanceBiz.load(chance);
        if (c.getChcCreateDate() != null) {
            c.setCdateName(sdf.format(c.getChcCreateDate()));
        }
        if (c.getChcDueDate() != null) {
            c.setDdateName(sdf.format(c.getChcDueDate()));
        }
        List<User> listUser = userBiz.list(user);
        model.addAttribute("listUser", listUser);
        model.addAttribute("chance", c);
        if(StringUtils.isNotBlank(chance.getForward())){
            return "system/sal/dispatch";
        }
        return "system/sal/editChance";
    }

    @RequestMapping("/toAddChance")
    public String toAddChance(){
        return "system/sal/addChance";
    }

    @RequestMapping("/delChance")
    public String delChance(Chance chance){
        chanceBiz.del(chance);
        return "redirect:/toListChance";
    }

    @RequestMapping("/addChance")
    @ResponseBody
    public String addChance(Chance chance){
        Date d = new Date();
        chance.setChcCreateDate(d);
        chanceBiz.add(chance);
        return "succen";
    }
    @RequestMapping("/editChance")
    @ResponseBody
    public String editChance(Chance chance){
        chanceBiz.editChance(chance);
        return "succen";
    }
    @RequestMapping("/dispatch")
    @ResponseBody
    public String dispatch(Chance chance){
        Date d = new Date();
        chance.setChcDueDate(d);
        chanceBiz.editChance(chance);
        return "succen";
    }

    @RequestMapping("/chance/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request, HttpServletResponse response){
        String chcCustName = request.getParameter("chcCustName");
        String chcTitle = request.getParameter("chcTitle");
        String chcLinkman = request.getParameter("chcLinkman");
        String page =request.getParameter("page");
        String rows =request.getParameter("rows");
        Chance chance = new Chance();
        if (StringUtils.isNotBlank(chcCustName)) {
            chance.setChcCustName(chcCustName);
        }
        if (StringUtils.isNotBlank(chcTitle)) {
            chance.setChcTitle(chcTitle);
        }
        if (StringUtils.isNotBlank(chcLinkman)) {
            chance.setChcLinkman(chcLinkman);
        }
        if (StringUtils.isNotBlank(page)) {
            this.page = Integer.parseInt(page);
        }
        if (StringUtils.isNotBlank(rows)) {
            this.rows = Integer.parseInt(rows);
        }
        PageHelper.startPage(this.page,this.rows);
        List<Chance> listChance = chanceBiz.list(chance);
        for (Chance c : listChance) {
            c.setAction("" +
                    "<img onclick='dispatch("+c.getChcId()+")'style='width: 15px;height: 15px;' title='指派' src='images/bt_linkman.gif' class='op_button' />" +
                    "<img onclick='jumpPage("+c.getChcId()+")' title='编辑'src='images/bt_edit.gif' class='op_button' />" +
                    "<img onclick='del(\""+c.getChcTitle()+"\","+c.getChcId()+")' title='删除' src='images/bt_del.gif' class='op_button' />" );
        }
        PageInfo<Chance> p = new PageInfo<Chance>(listChance);
        ResponseData responseData = new ResponseData();
        responseData.setRows(listChance);
        responseData.setTotal((int) p.getTotal());
        response.setContentType("text/plain;charset=utf-8");
        return responseData;
    }

}
