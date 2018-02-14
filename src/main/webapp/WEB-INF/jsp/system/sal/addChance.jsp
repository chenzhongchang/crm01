<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/addChance.js"></script>
</head>
<body onload="newTime()" style="background: white;">
<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="location.href='toListChance'">返回</button>
    <button class="common_button"  onclick="addsubmitForm()">保存</button>
    <%--id="btn_ok"--%>
</div>
<form id="ff" method="post" name="chance">
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td><input readonly class="easyui-textbox" disabled="disabled" /></td>
        <th>机会来源</th>
        <td>
            <input class="easyui-textbox" name="chcSource" size="20" data-options="required:false"/></td>
    </tr>
    <tr>
        <th>客户名称</th>
        <td><input class="easyui-textbox" id="chcCustName" name="chcCustName" size="20" data-options="required:true" /></td>
        <th>成功机率</th>
        <td><input class="easyui-textbox" name="chcRate" size="20" data-options="required:true" /></td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3"><input class="easyui-textbox" name="chcTitle" data-options="required:true" size="52" /></td>
    </tr>
    <tr>
        <th>联系人</th>
        <td><input  class="easyui-textbox" name="chcLinkman" size="20" data-options="required:true" /></td>
        <th>联系人电话</th>
        <td><input  class="easyui-textbox" name="chcTel" size="20" data-options="required:true" /></td>
    </tr>
    <tr>
        <th>机会描述</th>
        <td colspan="3"><textarea  class="easyui-textbox" name="chcDesc" style="width:30%;height:60px" data-options="required:true"></textarea></td>
    </tr>
    <tr>
        <th>创建人</th>
        <td><input class="easyui-textbox" readonly name="chcCreateBy" value="${usr.usrName}" size="20" data-options="required:true" />
            <input type="hidden" name="chcCreateId" value="${usr.usrId}" />
        </td>
        <th>创建时间</th>
        <td><input readonly disabled="disabled" id="ck" style='width:200px;' value="123"/></td>
    </tr>
</table>
<br />
</form>

<script>
    function newTime(){
        var time=new Date();
        var yyyy=time.getFullYear();
        var MM=time.getMonth();
        var dd=time.getDate();
        var HH=time.getHours();
        var mm=time.getMinutes();
        var ss=time.getSeconds();

        HH=HH<=9?"0"+HH:HH;
        mm=mm<=9?"0"+mm:mm;
        ss=ss<=9?"0"+ss:ss;

        HH=(HH==24?"00":HH)
        document.getElementById("ck").value= yyyy+"-"+MM+"-"+dd+" "+HH+":"+mm+":"+ss;
        setTimeout("newTime()",1000);
    }
</script>
</body>

</html>
