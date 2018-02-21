package com.zking.crm.sal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zking.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chance {
    private Long chcId;

    private String chcSource;

    private String chcCustName;

    private String chcTitle;

    private Integer chcRate;

    private String chcLinkman;

    private String chcTel;

    private String chcDesc;

    private Long chcCreateId;

    private String chcCreateBy;

    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date chcCreateDate;

    private Long chcDueId;

    private String chcDueTo;

    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date chcDueDate;

    private String chcStatus;


    //paramenters
    private Integer page;
    private Integer rows;
    private String action;
    private String forward;
    private String cdateName;
    private String ddateName;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Chance(Long chcId, String chcSource, String chcCustName, String chcTitle, Integer chcRate, String chcLinkman, String chcTel, String chcDesc, Long chcCreateId, String chcCreateBy, Date chcCreateDate, Long chcDueId, String chcDueTo, Date chcDueDate, String chcStatus) {
        this.chcId = chcId;
        this.chcSource = chcSource;
        this.chcCustName = chcCustName;
        this.chcTitle = chcTitle;
        this.chcRate = chcRate;
        this.chcLinkman = chcLinkman;
        this.chcTel = chcTel;
        this.chcDesc = chcDesc;
        this.chcCreateId = chcCreateId;
        this.chcCreateBy = chcCreateBy;
        this.chcCreateDate = chcCreateDate;
        this.chcDueId = chcDueId;
        this.chcDueTo = chcDueTo;
        this.chcDueDate = chcDueDate;
        this.chcStatus = chcStatus;
    }

    public Chance() {
        super();
    }

    public Long getChcId() {
        return chcId;
    }

    public void setChcId(Long chcId) {
        this.chcId = chcId;
    }

    public String getChcSource() {
        return chcSource;
    }

    public void setChcSource(String chcSource) {
        this.chcSource = chcSource;
    }

    public String getChcCustName() {
        return chcCustName;
    }

    public void setChcCustName(String chcCustName) {
        this.chcCustName = chcCustName;
    }

    public String getChcTitle() {
        return chcTitle;
    }

    public void setChcTitle(String chcTitle) {
        this.chcTitle = chcTitle;
    }

    public Integer getChcRate() {
        return chcRate;
    }

    public void setChcRate(Integer chcRate) {
        this.chcRate = chcRate;
    }

    public String getChcLinkman() {
        return chcLinkman;
    }

    public void setChcLinkman(String chcLinkman) {
        this.chcLinkman = chcLinkman;
    }

    public String getChcTel() {
        return chcTel;
    }

    public void setChcTel(String chcTel) {
        this.chcTel = chcTel;
    }

    public String getChcDesc() {
        return chcDesc;
    }

    public void setChcDesc(String chcDesc) {
        this.chcDesc = chcDesc;
    }

    public Long getChcCreateId() {
        return chcCreateId;
    }

    public void setChcCreateId(Long chcCreateId) {
        this.chcCreateId = chcCreateId;
    }

    public String getChcCreateBy() {
        return chcCreateBy;
    }

    public void setChcCreateBy(String chcCreateBy) {
        this.chcCreateBy = chcCreateBy;
    }

    public Date getChcCreateDate() {
        return chcCreateDate;
    }

    public void setChcCreateDate(Date chcCreateDate) {
        this.chcCreateDate = chcCreateDate;
    }
    public void setChcCreateDate(String chcCreateDate) {
        if(StringUtils.isNotBlank(chcCreateDate)) {
            this.cdateName = chcCreateDate;
        }
    }

    public Long getChcDueId() {
        return chcDueId;
    }

    public void setChcDueId(Long chcDueId) {
        this.chcDueId = chcDueId;
    }

    public String getChcDueTo() {
        return chcDueTo;
    }

    public void setChcDueTo(String chcDueTo) {
        this.chcDueTo = chcDueTo;
    }

    public Date getChcDueDate() {
        return chcDueDate;
    }

    public void setChcDueDate(Date chcDueDate) {
        this.chcDueDate = chcDueDate;
    }
    public void setChcDueDate(String chcDueDate) {
        if(StringUtils.isNotBlank(chcDueDate)){
            this.ddateName = chcDueDate;
        }
    }

    public String getChcStatus() {
        return chcStatus;
    }

    public void setChcStatus(String chcStatus) {
        this.chcStatus = chcStatus;
    }

    public String getCdateName() {
        return cdateName;
    }

    public void setCdateName(String cdateName) {
        this.cdateName = cdateName;
    }

    public String getDdateName() {
        return ddateName;
    }

    public void setDdateName(String ddateName) {
        this.ddateName = ddateName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Chance{" +
                "chcId=" + chcId +
                ", chcSource='" + chcSource + '\'' +
                ", chcCustName='" + chcCustName + '\'' +
                ", chcTitle='" + chcTitle + '\'' +
                ", chcRate=" + chcRate +
                ", chcLinkman='" + chcLinkman + '\'' +
                ", chcTel='" + chcTel + '\'' +
                ", chcDesc='" + chcDesc + '\'' +
                ", chcCreateId=" + chcCreateId +
                ", chcCreateBy='" + chcCreateBy + '\'' +
                ", chcCreateDate=" + chcCreateDate +
                ", chcDueId=" + chcDueId +
                ", chcDueTo='" + chcDueTo + '\'' +
                ", chcDueDate=" + chcDueDate +
                ", chcStatus='" + chcStatus + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", forward='" + forward + '\'' +
                '}';
    }
}