<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <title>Title</title>
    <%@include file="/common/hear.jsp"%>
    <style>
        th{
            font-size:12px;
            text-align:right;
            font-weight:normal;
        }
        td{
            font-size:12px;
            text-align:left;
        }
        input{
            width:100px;
            font-size:12px;
            border:solid 1px lightblue;
        }
    </style>
    <script type="text/javascript">
        function login1() {
            $('#user').form('submit', {
                url: "login",
                onSubmit: function () {        //表单提交前的回调函数
                    var isValid = $(this).form('validate');  //验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字
                    if (!isValid) {
                    }
                    return isValid; // 如果验证不通过，返回false终止表单提交
                },
                success: function (data) {
                    if (data == 'succen') {
                location.href="/crm01/index/toIndex"
                    }
                    else {
                        var msg;
                        if(data=="0"){
                            msg="帐号不存在";
                        }else{
                            msg="密码错误"
                        }
                        $.messager.alert('提示信息', ''+msg+'', 'warning');
                    }
                }
            });
        }
    </script>
</HEAD>
<BODY BGCOLOR=#FFFFFF style="text-align:center;padding-top:20px;">
<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0 style=" background-size:cover;" background="images/login/thime.jpg;">
    <TR>
        <TD COLSPAN=7>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=71 ALT=""></TD>
    </TR>
    <TR>
        <TD COLSPAN=7>&nbsp;

        </TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=66 ALT=""></TD>
    </TR>
    <TR>
        <TD COLSPAN=7>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=6 ALT=""></TD>
    </TR>
    <TR>

        <TD COLSPAN=3>&nbsp; </TD>
        <TD COLSPAN=3 ROWSPAN=2>

        <TD ROWSPAN=3>&nbsp;</TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=44 ALT=""></TD>
    </TR>
    <TR>

        <TD ROWSPAN=4>&nbsp; </TD>
        <TD COLSPAN=2>
            <IMG SRC="images/login/login_08.jpg" WIDTH=94 HEIGHT=39 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=39 ALT=""></TD>
    </TR>
    <TR>
        <TD ROWSPAN=3>
            <IMG SRC="images/login/login_09.jpg" WIDTH=15 HEIGHT=141 ALT=""></TD>

        <TD COLSPAN=2 ROWSPAN=2 background="images/login/login_10.jpg" >
            <form name="user" id="user" method="post">
            <table width="100%">
                <tr>
                    <th>用户名</th>
                    <td><input size="10" class="easyui-textbox"  data-options="required:true"  name="usrName" maxlength="20" /></td>
                </tr>
                <tr>
                    <th>密码</th>
                    <td><input type="password" class="easyui-textbox"  data-options="required:true" name="usrPassword" size="10" maxlength="20" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><img onclick="login1()" src="images/login/login_button.jpg" width="73" height="25"></td>
                </tr>
            </table>
            </form>
        </TD>
        <TD COLSPAN=2>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=86 ALT=""></TD>
    </TR>
    <TR>
        <TD ROWSPAN=2>
            <IMG SRC="images/login/login_12.jpg" WIDTH=19 HEIGHT=55 ALT=""></TD>

        <TD COLSPAN=2 ROWSPAN=3>&nbsp; </TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=28 ALT=""></TD>
    </TR>
    <TR>
        <TD COLSPAN=2>
            <IMG SRC="images/login/login_14.jpg" WIDTH=201 HEIGHT=27 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=27 ALT=""></TD>
    </TR>
    <TR>

        <TD COLSPAN=5>&nbsp; </TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=67 ALT=""></TD>
    </TR>
    <TR>


        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=55 ALT=""></TD>
    </TR>
    <TR>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=150 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=15 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=79 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=122 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=19 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=285 HEIGHT=1 ALT=""></TD>
        <TD>
            <IMG SRC="images/login/spacer.gif" WIDTH=130 HEIGHT=1 ALT=""></TD>
        <TD></TD>
    </TR>
</TABLE>
</BODY>
</HTML>