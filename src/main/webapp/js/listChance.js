$(function(){
    $('#dg').datagrid({
        pagination : true,
        pageList : [ 2, 4, 6, 8 ],
        pageSize : 2,
        pageNumber : 1,

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
            field : 'dateName',
            title : '创建时间',
            width : '25%'
        } ] ]
    });
    $("a.easyui-linkbutton").click(function(){
        var formData = {};
        var chcCustName = $("#chcCustName").val() || '';
        formData.chcCustName=chcCustName;
        $('#dg').datagrid({
            queryParams: formData
        });
        addFooterButton();
        return false;
    });
});
function addFooterButton(){
    var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of
    pager.pagination({
        buttons : [ {
            iconCls : 'icon-add',
            handler : function() {
                alert('add');
                parent.doOpenTab('toAddChance');
            }
        },'-',{
            iconCls : 'icon-edit',
            handler : function() {
                var row=$('#dg').datagrid('getSelected') || "";
                if(!row){
                    $.messager.alert('请选择要修改的项');
                }else{
                    parent.doOpenTab('chance/toLoad');
                }
                console.log(row);
            }
        },'-',{
            iconCls : 'icon-remove',
            handler : function() {
                alert('remove');
            }
        } ]
    });
}
