package com.zking.crm.sys.biz;

import com.zking.crm.sys.model.User;

import java.util.List;

public interface IUserBiz {

    List<User> list(User user);

    User load(User user);

}
