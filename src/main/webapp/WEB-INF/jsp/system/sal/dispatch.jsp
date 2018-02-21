<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <script type="text/javascript">
        function dispatch() {
            $('#dispatch').form('submit', {
                url: "dispatch",
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
<body style="background: white;" onload="newTime()">
<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="location.href='toListChance'">返回</button>
    <button class="common_button"  onclick="dispatch()">保存</button>
    <%--id="btn_ok"--%>
</div>
<%--<img onclick='jumpPage("+c.getChcId()+")' title='编辑'src='images/bt_edit.gif ' style="width: 12px;height: 12px;" class='op_button' />--%>

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
            <td colspan="3"> ${chance.chcTitle}</td>
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
    </table>
    <br />
<form id="dispatch" method="post" name="chance">
    <table disabled class="query_form_table" id="table1">
        <tr>
            <th>指派给</th>
            <td>
                <input type="hidden" name="chcId" value="${chance.chcId}" />
                <input type="hidden" name="chcStatus" value="2" />
                <f:select path="chance.chcDueId" >
                    <f:option value="">--请选择--</f:option>
                    <f:options items="${listUser}" itemLabel="usrName" itemValue="usrId"/>
                </f:select>
                <span class="red_star">*</span></td>
            <th>指派时间</th>
            <td>
                <c:if test="${null == chance.ddateName}">
                <input readonly disabled="disabled" id="ck" style='width:200px;' value="13" />
                </c:if>
                <c:if test="${chance.ddateName !=null}">
                    <input readonly class="easyui-textbox" name="ddateName" value="${chance.ddateName}"  /><span class="red_star">*</span>
                    <input type="hidden" name="chcDueDate" value="${chance.chcDueDate}"  />
                </c:if>
            </td>
        </tr>
    </table>
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
    }
</script>
</body>
</html>