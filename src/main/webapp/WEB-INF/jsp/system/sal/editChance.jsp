<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <script type="text/javascript">
        function editsubmitForm() {
            $('#eform').form('submit', {
                url: "editChance",
                onSubmit: function () {        //表单提交前的回调函数
                    var isValid = $(this).form('validate');//验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字
                    if (!isValid) {
                    }
                    return isValid; // 如果验证不通过，返回false终止表单提交
                },
                success: function (data) {  //表单提交成功后的回调函数，里面参数data是我们调用/BasicClass/ModifyClassInfo方法的返回值。
                   if(data.length>0){
                       location.href="/crm01/toListChance";
                   }
                }
            });
        }
    </script>
</head>
<body style="background: white;">
<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="location.href='toListChance'">返回</button>
    <button class="common_button"  onclick="editsubmitForm()">保存</button>
    <%--id="btn_ok"--%>
</div>
<form id="eform" method="post" name="chance">
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td><input readonly class="easyui-textbox" name="chcId" value="${chance.chcId}" disabled="disabled" />
            <input type="hidden" name="chcId" value="${chance.chcId}" />
        </td>
        <th>机会来源</th>
        <td>
            <input class="easyui-textbox" name="chcSource" value="${chance.chcSource}" size="20" data-options="required:false"/></td>
    </tr>
    <tr>
        <th>客户名称</th>
        <td><input class="easyui-textbox" id="chcCustName"  value="${chance.chcCustName}" name="chcCustName" size="20" data-options="required:true" /></td>
        <th>成功机率</th>
        <td><input class="easyui-textbox" name="chcRate" value="${chance.chcRate}" size="20" data-options="required:true" /></td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3"><input class="easyui-textbox" name="chcTitle" value="${chance.chcTitle}" data-options="required:true" size="52" /></td>
    </tr>
    <tr>
        <th>联系人</th>
        <td><input  class="easyui-textbox" name="chcLinkman" value="${chance.chcLinkman}" size="20" data-options="required:true" /></td>
        <th>联系人电话</th>
        <td><input  class="easyui-textbox" name="chcTel" value="${chance.chcTel}" size="20" data-options="required:true" /></td>
    </tr>
    <tr>
        <th>机会描述</th>
        <td colspan="3"><textarea class="easyui-textbox" name="chcDesc" style="width:30%;height:60px" data-options="required:true">${chance.chcDesc}</textarea></td>
    </tr>
    <tr>
        <th>创建人</th>
        <td><input class="easyui-textbox" readonly name="chcCreateBy" value="${chance.chcCreateBy}" size="20" data-options="required:true" />
            <input type="hidden" name="chcCreateId" value="${chance.chcCreateId}" />
        </td>
        <th>创建时间</th>
        <td><input readonly class="easyui-textbox" readonly name="cdateName" value="${chance.cdateName}" />
            <input type="hidden" name="chcCreateDate" value="${chance.chcCreateDate}"/>
        </td>
    </tr>
</table>
<br />
    <table disabled class="query_form_table" id="table1">
        <tr>
            <th>指派给</th>
            <td>
                <f:select path="chance.chcDueId" disabled="true" >
                    <f:option value="">--请选择--</f:option>
                    <f:options items="${listUser}" itemLabel="usrName" itemValue="usrId"/>
                </f:select>
                <span class="red_star">*</span></td>
            <th>指派时间</th>
            <td>
                <input readonly class="easyui-textbox" name="ddateName" value="${chance.ddateName}" disabled="disabled" /><span class="red_star">*</span>
                <c:if test="${chance.ddateName} !=null">
                <input type="hidden" name="chcDueDate" value="${chance.chcDueDate}"/>
                </c:if>
            </td>
        </tr>
    </table>
</form>
<script>
    setCurTime('t1');
    setCurTime('t2');
</script>
</body>
</html>