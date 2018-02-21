<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <c:if test="${!empty msg}">
        <script type="text/javascript">
            var msg = "${msg}";
            function messager(){
                alert(msg);
            }
            window.onload=messager();
        </script>
        <c:remove var="msg"  scope="session"/>
    </c:if>
    <script language="javascript" type="text/javascript" src='<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js'>
    </script>
    <script type="text/javascript">
        function addForm() {
            alert(document.getElementById("pdateName").value);
            $('#addPlan').form('submit', {
                url: "plan/add",
                onSubmit: function () {        //表单提交前的回调函数
                    var isValid = $(this).form('validate');//验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字
                    if (!isValid) {
                    }
                    return isValid; // 如果验证不通过，返回false终止表单提交
                },
                success: function (data) {  //表单提交成功后的回调函数，里面参数data是我们调用/BasicClass/ModifyClassInfo方法的返回值。
                   if("success"==data){
                       $.messager.show({
                           title: '提示消息',
                           msg: '新建成功',
                           showType: 'show',
                           timeout: 1000,
                           style: {right: '', bottom: ''}
                       });
                       location.href="chance/toDevPlan?chcId="+${chance.chcId};
                   }
                }
            });
        }
        function editPlan(pid) {
            $('#editPlan_'+pid).form('submit', {
                url: "plan/edit",
                onSubmit: function () {        //表单提交前的回调函数
                    var isValid = $(this).form('validate');//验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字
                    if (!isValid) {
                    }
                    return isValid; // 如果验证不通过，返回false终止表单提交
                }
            });
        }
        function pdel(id){
            location.href="plan/del?plaId="+id+"&plaChcId="+${chance.chcId};
            return false;
        }
        function hidden(name){
           var ra= document.getElementsByName(name);
           for(var i=0;i<ra.length;i++){
                   ra[i].style.display="none";
           }
        }
        function show(name){
           var ra= document.getElementsByName(name);
           for(var i=0;i<ra.length;i++){
                   ra[i].style.display="block";
           }
        }
        function onChange(name){
         var ac = new Array();
         ac[0]="table1";
         ac[1]="table3";
         if(ac[0]==name){
             show(ac[0]);
             hidden(ac[1]);
         }else{
             show(ac[1]);
             hidden(ac[0]);
         }
        }
    </script>
</head>
<body>
<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar" name="table1">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="onChange('table3');">执行计划</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<div class="button_bar" name="table3"  style="display:none;"  >
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="alert('开发失败，已归档。');window.location.href='chance/exeStatus?chcId=${chance.chcId}&chcStatus=4';">终止开发</button>
    <button class="common_button" onclick="onChange('table1');">制定计划</button>
    <button class="common_button" onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='chance/exeStatus?chcId=${chance.chcId}&chcStatus=3';">开发成功</button>

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
<table class="data_list_table" id="table1"  name="table1">
    <tr>
        <th width="150px">日期</th>
        <th height="31">计划项</th>
    </tr>
    <c:forEach items="${listPlan}" var="v" >
        <tr>
            <td class="list_data_text" height="24">${v.pdateName}</td>
            <td class="list_data_ltext" height="24">
                <form name="plan" id="editPlan_${v.plaId}" method="post">
                <input size="50" name="plaTodo" value="${v.plaTodo}" />
                <input type="hidden" name="plaId" value="${v.plaId}" />
                <input type="hidden" size="50" name="plaChcId" value="${chance.chcId}" />
                </form>
                <button class="common_button" onclick="editPlan(${v.plaId});">保存</button>
                <button class="common_button" onclick="pdel(${v.plaId});">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="button_bar" name="table1">
    <button class="common_button" onclick="addForm();">保存</button>
</div>
<table class="query_form_table" id="table2" name="table1">
    <form name="plan" method="post" id="addPlan">
        <tr>
            <th>日期</th>
            <td><input name="pdateName" id="pdateName" class="Wdate"  onfocus="FocusItem(this)" onblur="CheckItem(this);" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})" /><span class="red_star">*</span></td>
            <th>计划项</th>
            <td>
                <input size="50" name="plaTodo" /><span class="red_star">*</span>
                <input type="hidden" size="50" name="plaChcId" value="${chance.chcId}" />
            </td>
        </tr>
    </form>
</table>
<table name="table3" style="display:none;" class="query_form_table" >
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
        <td class="list_data_ltext"><input type="text" name="plaResult" value="${v.plaResult}" />　
            <input type="hidden" name="plaId" value="${v.plaId}" />
            <input type="hidden" size="50" name="plaChcId" value="${chance.chcId}" />
            <input type="hidden" size="50" name="forward" value="execute" />
            <button class="common_button" onclick="editPlan('${v.plaId}0');">保存</button>
        </td>
    </tr>
    </form>
    </c:forEach>
</table>

<c:if test="${!empty chance.forward}">
    <script type="text/javascript">
        onChange('table3');
    </script>
</c:if>
</body>
</html>