package com.zking.crm.cst.mapper;

import com.zking.crm.cst.model.Linkman;

import java.util.List;

public interface LinkmanMapper {
    int deleteByPrimaryKey(Long lkmId);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    Linkman selectByPrimaryKey(Long lkmId);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);

    List<Linkman> list(Linkman linkman);
}