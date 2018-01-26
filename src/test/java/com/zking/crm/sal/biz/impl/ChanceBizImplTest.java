package com.zking.crm.sal.biz.impl;

import com.zking.crm.sal.biz.IChanceBiz;
import com.zking.crm.sal.model.Chance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChanceBizImplTest extends BaseTestCase {

    @Autowired
    private IChanceBiz chanceBiz;

    private Chance chance;

    @Test
    public void list() throws Exception {
        chance = new Chance();
//        chance.setChcTitle("AAA");
//        chance.setChcCustName("a");
        chance.setChcLinkman("aa");
        List<Chance> list = chanceBiz.list(chance);
        for (Chance c : list) {
            System.out.println(c);
        }
    }

    @Test
    public void load() throws Exception {
    }

    @Test
    public void editChance() throws Exception {
    }

    @Test
    public void del() throws Exception {
    }
    @Test
    public void add() throws Exception {
        chance = new Chance();
        chance.setChcSource("");
        chance.setChcCustName("");
        chance.setChcLinkman("");
//        chance.setChcRate("");
//        chance.setChcLinkman();

    }

}