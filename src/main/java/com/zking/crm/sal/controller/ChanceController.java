package com.zking.crm.sal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.crm.sal.biz.IChanceBiz;
import com.zking.crm.sal.biz.IPlanBiz;
import com.zking.crm.sal.model.Chance;
import com.zking.crm.sal.model.Plan;
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
//    private Integer page;
//    private Integer rows;

    @Autowired
    private IChanceBiz chanceBiz;

    @Autowired
    private IUserBiz userBiz;
    private User user = new User();
    @Autowired
    private IPlanBiz planBiz;
    private Plan plan = new Plan();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");

    @RequestMapping("/toListChance")
    public String toListChance(){
        return "system/sal/listChance";
    }
    @RequestMapping("/toListChance1")
    public String toListChance1(){
        return "system/sal/dev";
    }

    @RequestMapping("/chance/toEload")
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
    @RequestMapping("/chance/toDevPlan")
    public String toDevPlan(Chance chance,Model model){
        Chance c = chanceBiz.load(chance);
        if (c.getChcCreateDate() != null) {
            c.setCdateName(sdf.format(c.getChcCreateDate()));
        }
        if (c.getChcDueDate() != null) {
            c.setDdateName(sdf.format(c.getChcDueDate()));
        }
        plan.setPlaChcId(c.getChcId());
        List<Plan> listPlan = planBiz.list(plan);
        for (Plan p : listPlan) {
            p.setPdateName(sdf2.format(p.getPlaDate()));
        }
        if (StringUtils.isNotBlank(chance.getForward())) {
            c.setForward(chance.getForward());
        }
        model.addAttribute("listPlan", listPlan);
        model.addAttribute("chance", c);
        return "system/sal/devPlan";
    }
    @RequestMapping("/chance/toDevPlanDetail")
    public String toDevPlanDetail(Chance chance,Model model){
        Chance c = chanceBiz.load(chance);
        if (c.getChcCreateDate() != null) {
            c.setCdateName(sdf.format(c.getChcCreateDate()));
        }
        if (c.getChcDueDate() != null) {
            c.setDdateName(sdf.format(c.getChcDueDate()));
        }
        plan.setPlaChcId(c.getChcId());
        List<Plan> listPlan = planBiz.list(plan);
        for (Plan p : listPlan) {
            p.setPdateName(sdf2.format(p.getPlaDate()));
        }
        model.addAttribute("listPlan", listPlan);
        model.addAttribute("chance", c);
        return "system/sal/devPlanDetail";
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
    @RequestMapping("/chance/exeStatus")
    public String exeStatus(Chance chance,HttpServletRequest request){
        chanceBiz.editChance(chance);
        if ("3".equals(chance.getChcStatus())) {
            request.getSession().setAttribute("msg","用户开发成功,已添加新客户记录。");
        }else{
            request.getSession().setAttribute("msg","开发失败,已归档。");
        }
            return "redirect:/toListChance1";

    }

    @RequestMapping("/chance/list")
    @ResponseBody
    public ResponseData list(Chance chance){
        PageHelper.startPage(chance.getPage(),chance.getRows());
        List<Chance> listChance = chanceBiz.list(chance);
        if (StringUtils.isNotBlank(chance.getForward())) {
            doAction1(listChance);
        }else{
            doAction(listChance);
        }
        PageInfo<Chance> p = new PageInfo<Chance>(listChance);
        ResponseData responseData = new ResponseData();
        responseData.setRows(listChance);
        responseData.setTotal((int) p.getTotal());
        return responseData;
    }

   public void doAction(List<Chance> listChance){
    for (Chance c : listChance) {
        c.setAction("" +
                "<img onclick='dispatch("+c.getChcId()+")'style='width: 15px;height: 15px;' title='指派' src='images/bt_linkman.gif' class='op_button' />" +
                "<img onclick='jumpPage("+c.getChcId()+")' title='编辑'src='images/bt_edit.gif' class='op_button' />" +
                "<img onclick='del(\""+c.getChcTitle()+"\","+c.getChcId()+")' title='删除' src='images/bt_del.gif' class='op_button' />" );
     }
  }
   public void doAction1(List<Chance> listChance){
    for (Chance c : listChance) {
        if ("2".equals(c.getChcStatus().trim())) {
            c.setAction("" +
                    "<img onclick='devPlan("+c.getChcId()+")' title='制定计划' src='images/bt_plan.gif' class='op_button' />" +
                    "<img onclick='devExecute("+c.getChcId()+",\"execute\")' title='执行计划' src='images/bt_feedback.gif' class='op_button' />" +
                    "<img onclick='doExeChcStatus("+c.getChcId()+")'; title='开发成功' src='images/bt_yes.gif' class='op_button' />" );
        }else {
            c.setAction("<img onclick='devPlanDetail("+c.getChcId()+");' title='查看' src='images/bt_detail.gif' class='op_button' />" );
        }
     }
  }
}
