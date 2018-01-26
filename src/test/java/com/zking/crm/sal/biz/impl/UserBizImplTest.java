package com.zking.crm.sal.biz.impl;

import com.zking.crm.sys.biz.IUserBiz;
import com.zking.crm.sys.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserBizImplTest extends BaseTestCase {

    @Autowired
    private IUserBiz userBiz;

    private User user;


    @Test
    public void list() throws Exception {
        user = new User();
        List<User> list = userBiz.list(user);
        for (User u : list) {
            System.out.println(u);
        }

    }

    @Test
    public void load() throws Exception {
        user = new User();
        user.setUsrName("ss");
        User u = userBiz.load(user);
        System.out.println(u);
    }

}