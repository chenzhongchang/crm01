package com.zking.crm.sal.biz.impl;

import com.zking.crm.sal.biz.IChanceBiz;
import com.zking.crm.sal.mapper.ChanceMapper;
import com.zking.crm.sal.model.Chance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChanceBizImpl implements IChanceBiz {

    @Autowired
    private ChanceMapper chanceMapper;

    @Override
    public List<Chance> list(Chance chance) {
        return chanceMapper.list(chance);
    }

    @Override
    public Chance load(Chance chance) {
        return chanceMapper.selectByPrimaryKey(chance.getChcId());
    }

    @Override
    public void editChance(Chance chance) {
        chanceMapper.insertSelective(chance);
    }

    @Override
    public void del(Chance chance) {
        chanceMapper.deleteByPrimaryKey(chance.getChcId());
    }

    @Override
    public void add(Chance chance) {
        chanceMapper.insertSelective(chance);
    }
}
