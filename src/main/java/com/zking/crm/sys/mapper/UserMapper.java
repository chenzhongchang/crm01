package com.zking.crm.sys.mapper;

import com.zking.crm.sys.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long usrId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User usr);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list(User user);
}