package com.zking.crm.cst.mapper;

import com.zking.crm.cst.model.Lost;

public interface LostMapper {
    int deleteByPrimaryKey(Long lstId);

    int insert(Lost record);

    int insertSelective(Lost record);

    Lost selectByPrimaryKey(Long lstId);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}