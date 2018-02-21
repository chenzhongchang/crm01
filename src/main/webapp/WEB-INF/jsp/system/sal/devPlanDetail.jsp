<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
</head>
<body>
<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar" name="table1">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td>${chance.chcId}
        </td>
        <th>机会来源</th>
        <td>
            ${chance.chcSource}
        </td>
    </tr>
    <tr>
        <th>客户名称</th>
        <td>  ${chance.chcCustName}</td>
        <th>成功机率</th>
        <td> ${chance.chcRate}</td>
    </tr>
    <tr>
        <th>概要</th>
        <td> ${chance.chcTitle}</td>
        <th>状态</th>
        <td style="color:red;"><c:if test="${chance.chcStatus.trim() eq '3'}">开发成功</c:if> <c:if test="${chance.chcStatus.trim() == '4'}">开发失败</c:if></td>
    </tr>
    <tr>
        <th>联系人</th>
        <td> ${chance.chcLinkman}</td>
        <th>联系人电话</th>
        <td> ${chance.chcTel}</td>
    </tr>
    <tr>
        <th>机会描述</th>
        <td colspan="3"> ${chance.chcDesc}</td>
    </tr>
    <tr>
        <th>创建人</th>
        <td> ${chance.chcCreateBy}
        </td>
        <th>创建时间</th>
        <td>${chance.cdateName}
        </td>
    </tr>
    <tr>
        <th>指派给</th>
        <td> ${chance.chcDueId}
        </td>
        <th>指派时间</th>
        <td>${chance.ddateName}
        </td>
    </tr>
</table>
<br />
<table name="table3" class="query_form_table" >
    <tr>
        <th>日期</th>
        <th>计划</th>
        <th>执行效果</th>
    </tr>
    <c:forEach items="${listPlan}" var="v" >
    <form name="plan" id="editPlan_${v.plaId}0" method="post">
    <tr>
        <td class="list_data_text">${v.pdateName}</td>
        <td class="list_data_ltext">${v.plaTodo}</td>
        <td class="list_data_ltext">${v.plaResult}</td>
    </tr>
    </form>
    </c:forEach>
</table>
</body>
</html>