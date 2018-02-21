package com.zking.crm.sal.controller;

import com.zking.crm.sal.biz.IPlanBiz;
import com.zking.crm.sal.model.Plan;
import com.zking.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlanController {

    @Autowired
    private IPlanBiz planBiz;

    @RequestMapping("/plan/add")
    @ResponseBody
    public String add(Plan plan){
        plan.setPlaDate(plan.getPdateName());
        planBiz.add(plan);
        return "success";
    }
    @RequestMapping("/plan/edit")
    public String edit(Plan plan, HttpServletRequest request){
        planBiz.edit(plan);
        request.getSession().setAttribute("msg","保存成功");
        if(StringUtils.isNotBlank(plan.getForward())){
            return "redirect:/chance/toDevPlan?chcId="+plan.getPlaChcId()+"&forward="+plan.getForward();
        }
        return "redirect:/chance/toDevPlan?chcId="+plan.getPlaChcId();
    }
    @RequestMapping("/plan/del")
    public String del(Plan plan){
        planBiz.del(plan);
        return "redirect:/chance/toDevPlan?chcId="+plan.getPlaChcId();
    }

}
