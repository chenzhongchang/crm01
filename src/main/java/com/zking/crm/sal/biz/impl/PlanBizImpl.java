package com.zking.crm.sal.biz.impl;

import com.zking.crm.sal.biz.IPlanBiz;
import com.zking.crm.sal.mapper.PlanMapper;
import com.zking.crm.sal.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanBizImpl implements IPlanBiz {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<Plan> list(Plan plan) {
        return planMapper.list(plan);
    }

    @Override
    public void edit(Plan plan) {
        planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public void del(Plan plan) {
        planMapper.deleteByPrimaryKey(plan.getPlaId());
    }

    @Override
    public void add(Plan plan) {
        planMapper.insertSelective(plan);
    }
}
