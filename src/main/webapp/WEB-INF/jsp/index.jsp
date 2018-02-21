<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@include file="/common/hear.jsp"%>
<script type="text/javascript">
    $(function(){
        $(".easyui-tree").each(function(){
            $(this).tree({
                onSelect:function(node){
                    if(!node.attributes.url)return;
                    var href = node.attributes.url;
                    doOpenTab(href);
                }
            });
        });
    });
    function doOpenTab(href){
        $("#myTabs").html('<iframe scrolling="no" framebordeer="0" src="' + href + '" style="width: 99%;height: 99%;"></iframe>');
    }
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:100px;">
    <TABLE style="width:100%;">
        <TR >
            <td ><img src="images/logo.jpg"></td>
            <td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>
            <td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：${usr.usrName} &nbsp;&nbsp; 退出系统 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; </td>
        </tr>
    </table>
</div>
<div data-options="region:'west'" class="easyui-accordion" style="width:20%;background:#0066CC;">
    <ul class="easyui-tree" data-options="url:'treeNode/list'"></ul>
</div>
<div data-options="region:'center'" id="myTabs" style="padding:0px;background:#eee;">
    <img src="images/welcome.jpg" />
</div>
<div data-options="region:'south'" style="height:80px;">
    <div style="text-align:right;padding:6px;">
        &copy;  2018 ***有限公司 技术部 第5组
    </div>
</div>
</body>
</html>
