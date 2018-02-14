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
<div data-options="region:'north'" style="height:100px;"></div>
<div data-options="region:'west'" class="easyui-accordion" style="width:20%;background:#0066CC;">
    <ul class="easyui-tree" data-options="url:'treeNode/list'"></ul>
</div>
<div data-options="region:'center'" id="myTabs" style="padding:0px;background:#eee;">
</div>
<div data-options="region:'south'" style="height:80px;"></div>
</body>
</html>
