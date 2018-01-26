package com.zking.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        java.util.Date d = new Date();

         String dateName;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        String  = sdf.format(d);

        System.out.println(sdf.format(d));
    }
}
