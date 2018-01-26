package com.zking.crm.sal.biz.impl;

import com.zking.util.PageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTestCase {

    private PageBean pageBean;

    @Before
    public void setUp() throws Exception {
        pageBean = new PageBean();
    }

    @After
    public void tearDown() throws Exception {
    }
}
