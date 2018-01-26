package com.zking.crm.sys.biz.impl;

import com.zking.crm.sys.biz.IUserBiz;
import com.zking.crm.sys.mapper.UserMapper;
import com.zking.crm.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImpl implements IUserBiz {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(User user) {
        return userMapper.list(user);
    }

    @Override
    public User load(User user) {
        return userMapper.selectByPrimaryKey(user);
    }
}
