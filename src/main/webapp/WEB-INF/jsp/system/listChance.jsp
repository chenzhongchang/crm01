<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/listChance.js"></script>
</head>
<body>
<h3>销售机会管理</h3>
<table id="dg"></table>
<div id="tb" style="padding:2px 5px;">
    客户名称: <input id="chcCustName" style="width:120px">
    <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
</div>

</body>
