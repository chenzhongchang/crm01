package com.zking.crm.sal.biz;

import com.zking.crm.sal.model.Chance;

import java.util.List;

public interface IChanceBiz {

    List<Chance> list(Chance chance);

    Chance load(Chance chance);

    void editChance(Chance chance);

    void del(Chance chance);

    void add(Chance chance);

}
