package com.zking.crm.sal.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan {
    private Long plaId;

    private Long plaChcId;

    private Date plaDate;

    private String plaTodo;

    private String plaResult;


    //parameters
    private String forward;
    private String pdateName;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

    public Plan(Long plaId, Long plaChcId, Date plaDate, String plaTodo, String plaResult) {
        this.plaId = plaId;
        this.plaChcId = plaChcId;
        this.plaDate = plaDate;
        this.plaTodo = plaTodo;
        this.plaResult = plaResult;
    }

    public Plan() {
        super();
    }

    public Long getPlaId() {
        return plaId;
    }

    public void setPlaId(Long plaId) {
        this.plaId = plaId;
    }

    public Long getPlaChcId() {
        return plaChcId;
    }

    public void setPlaChcId(Long plaChcId) {
        this.plaChcId = plaChcId;
    }

    public Date getPlaDate() {
        return plaDate;
    }

    public void setPlaDate(Date plaDate) {
        this.plaDate = plaDate;
    }
    public void setPlaDate(String plaDate) {
        try {
            this.plaDate =  sdf.parse(plaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPlaTodo() {
        return plaTodo;
    }

    public void setPlaTodo(String plaTodo) {
        this.plaTodo = plaTodo;
    }

    public String getPlaResult() {
        return plaResult;
    }

    public void setPlaResult(String plaResult) {
        this.plaResult = plaResult;
    }

    public String getPdateName() {
        return pdateName;
    }

    public void setPdateName(String pdateName) {
        this.pdateName = pdateName;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    @Override
    public String
    toString() {
        return "Plan{" +
                "plaId=" + plaId +
                ", plaChcId=" + plaChcId +
                ", plaDate=" + plaDate +
                ", plaTodo='" + plaTodo + '\'' +
                ", plaResult='" + plaResult + '\'' +
                ", pdateName='" + pdateName + '\'' +
                '}';
    }
}