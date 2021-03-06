<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <script type="text/javascript">
        $(function(){
            $('#dg').datagrid({
                toolbar : '#tb',
                pagination : true,
                pageList : [ 5, 8, 10 ],
                pageSize : 5,
                pageNumber : 1,

                method: 'get',
                collapsible: false,
                singleSelect : true,
                fit : false,
                url : 'chance/list',
                columns : [ [ {
                    field : 'chcId',
                    title : '编号',
                    width : '15%'
                }, {
                    field : 'chcCustName',
                    title : '客户名称',
                    width : '15%'
                }, {
                    field : 'chcTitle',
                    title : '概要',
                    width : '15%'
                }, {
                    field : 'chcLinkman',
                    title : '联系人',
                    width : '15%'
                }, {
                    field : 'chcTel',
                    title : '联系人电话',
                    width : '15%'
                }, {
                    field : 'chcCreateDate',
                    title : '创建时间',
                    width : '18%'
                } ,{
                    field : 'action',
                    title : '操作',
                    width : '7%'
                } ] ]
            });
            $("a.easyui-linkbutton").click(function(){
                var formData = {};
                var chcCustName = $("#chcCustName").val() || '';
                var chcTitle = $("#chcTitle").val() || '';
                var chcLinkman = $("#chcLinkman").val() || '';
                formData.chcCustName=chcCustName;
                formData.chcTitle=chcTitle;
                formData.chcLinkman=chcLinkman;
                $('#dg').datagrid({
                    queryParams: formData
                });
                return false;
            });
        });

    </script>
</head>
<body>
<h3>销售机会管理</h3>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="to('toAddChance');">新建</button>
</div>
<table id="dg"></table>
<div id="tb" style="padding:2px 5px;">
    客户名称: <input id="chcCustName" style="width:120px">
    概要: <input id="chcTitle" style="width:120px">
    联系人: <input id="chcLinkman" style="width:120px">
    <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
</div>
<script type="text/javascript">
    function jumpPage(id){
        location.href="chance/toEload?chcId="+id;
    }
    function del(msg,id){
        if (window.confirm("确认删除"+msg+"？")){
            location.href="delChance?chcId="+id;
        }
    }
    function dispatch(id){
            location.href="chance/toEload?chcId="+id+"&forward=toDload";
    }
</script>
</body>
