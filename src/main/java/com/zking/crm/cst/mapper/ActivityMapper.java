package com.zking.crm.cst.mapper;

import com.zking.crm.cst.model.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Long atvId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long atvId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> list(Activity activity);

}