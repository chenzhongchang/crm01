package com.zking.crm.sal.mapper;

import com.zking.crm.sal.model.Chance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChanceMapper {
    int deleteByPrimaryKey(Long chcId);

    int insert(Chance record);

    int insertSelective(Chance record);

    Chance selectByPrimaryKey(Long chcId);

    int updateByPrimaryKeySelective(Chance record);

    int updateByPrimaryKey(Chance record);

    List<Chance> list(Chance chance);
}