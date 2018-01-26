package com.zking.crm.cst.mapper;

import com.zking.crm.cst.model.Customer;

import java.util.List;

public interface CustomerMapper {

    int deleteByPrimaryKey(String custNo);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String custNo);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> listCustomeer(Customer customer);
}