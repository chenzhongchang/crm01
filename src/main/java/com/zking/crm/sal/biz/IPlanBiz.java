package com.zking.crm.sal.biz;

import com.zking.crm.sal.model.Plan;

import java.util.List;

public interface IPlanBiz {

    List<Plan> list(Plan plan);

    void edit(Plan plan);

    void del(Plan plan);

    void add(Plan plan);
}
