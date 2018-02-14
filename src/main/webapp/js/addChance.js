function addsubmitForm() {
    $('#ff').form('submit', {
        url: "addChance",
        onSubmit: function () {        //表单提交前的回调函数
            var isValid = $(this).form('validate');//验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字
            if (!isValid) {
            }
            return isValid; // 如果验证不通过，返回false终止表单提交
        },
        success: function (data) {  //表单提交成功后的回调函数，里面参数data是我们调用/BasicClass/ModifyClassInfo方法的返回值。
            if (data.length > 0) {
                $.messager.show({
                    title: '提示消息',
                    msg: '提交成功',
                    showType: 'show',
                    timeout: 1000,
                    style: {right: '', bottom: ''}
                });
                // $('#dg').datagrid('reload');  // 重新载入当前页面数据
                $('#ff').window('close'); //关闭窗口
            }
            else {
                $.messager.alert('提示信息', '提交失败，请联系管理员！', 'warning');
            }
        }
    });
}