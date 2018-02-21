package com.zking.crm.sal.mapper;

import com.zking.crm.sal.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMapper {

    int deleteByPrimaryKey(Long plaId);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Long plaId);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    List<Plan> list(Plan plan);
}