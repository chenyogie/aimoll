//阻止浏览器原有的右键菜单弹出
function doNothing() {
    window.event.returnValue = false;
    return false;
}

function deptFormat(value, row, index) {
    return value ? value.name : "";
}

function imgFormat(value, row, index) {
    return `<img src='${value}' alt='无图片' width="50px" height="50px"/>`;
}

function statusFormat(value, row, index) {
    return value ? "否" : "是";
}

function showMenu(e, index, row) {
    //选中这个行
    $("#employeeGrid").datagrid("selectRow", index);
    //第0个位置的面板不支持相应功能
    e.preventDefault();
    $('#gridMenu').menu('show', {
        left: e.pageX,
        top: e.pageY,
        onClick: function (item) {
            switch (item.text) {
                case "添加" : {
                    mymethod.add();
                }
                    ;
                    break;
                case "修改" : {
                    mymethod.update();
                }
                    ;
                    break;
                case "删除" : {
                    mymethod.del();
                }
                    ;
                    break;
            }
        }
    });
}

//自定义验证(验证用户名是否可用)
$.extend($.fn.validatebox.defaults.rules, {
    //验证的名称
    checkName: {
        /**
         * 自定义验证
         * @param value 文本框中的值
         * @param param 调用验证传过来的数组
         */
        validator: function (value, param) {
            //发送ajax请求到后台验证
            /*$.ajax({
                sync:false,
                type:'get',
                url:'/employee/checkName',
                data:{'username':value},
                dataType:'json',
                success:function (data) {
                    console.log("data:"+data);
                    //函数内部不能读取外部的值
                    //因为闭包
                    result = data;
                }
            });*/
            //从隐藏域拿到employeeId
            let $employeeId = $("#employeeId").val();
            let result = $.ajax({
                url: "/employee/checkName",
                data: {username: value, id: $employeeId},
                async: false //false就是同步
            }).responseText;
            return JSON.parse(result);
        },
        //如果被占用的提示
        message: '此用户名已被占用，请重新命名！'
    }
})

$(function () {

    /*为每一个带有data-method属性的a标签绑定click事件*/
    $("a[data-method]").on("click", function () {
        /*获取方法的名称*/
        let methodName = $(this).data("method");
        /*调用方法*/
        window.mymethod[methodName]();
    });

    /*拿到常用的组件*/
    let employeeGrid = $("#employeeGrid");
    let searchForm = $("#searchForm");
    let employeeDialog = $("#employeeDialog");
    let editForm = $("#editForm");

    /*方法的定义*/
    mymethod = {
        add() {
            $("*[data-edit]").show();
            $("*[data-edit] input").validatebox("enable");
            //先清空
            editForm.form("clear");
            employeeDialog.dialog("center").dialog("open");
        },
        del() {//多行删除
            /*let row = employeeGrid.datagrid("getSelected");*/
            let rows = employeeGrid.datagrid("getSelections");
            //如果用户没有选中行
            if (!rows) {
                $.messager.alert("警告", "请至少选中一行数据再删除！", "warning");
                return;
            } else {
                //发送邮箱验证码的请求
                $.ajax({
                    type: "POST",
                    url: "/email/sendEmail",
                    async: true,//异步
                    success: function () {
                    }
                });

                /*如果已经选中，提示是否确认进行删除操作*/
                $.messager.prompt('提示信息', '验证码已发送至您的邮箱，请输入您的验证码：', function (mailCode) {
                    if (mailCode) {
                        //alert('您的验证码是：' + mailCode);
                        $.ajax({
                            type: "POST",
                            url: "/employee/validateCode",
                            async: false,//同步
                            data: {mailCode:mailCode},
                            success: function (data) {
                                if (data.success) {
                                    //$.messager.alert("警告", data.msg, "warrning");
                                    $.messager.confirm('确认', `您确认想要删除这${rows.length}条记录吗？`, function (r) {
                                        if (r) {
                                            for (let i = 0; i < rows.length; i++) {
                                                $.get('/employee/delete', {id: rows[i].id}, function (result) {
                                                    if (result.success) {
                                                        employeeGrid.datagrid("reload");
                                                    } else {
                                                        $.messager.alert("错误", "删除失败，原因：" + result.msg, "error")
                                                    }
                                                    //关闭对话框
                                                    mymethod.close();
                                                });
                                            }
                                        }
                                    });
                                } else {
                                    $.messager.alert("错误", data.msg, "error");
                                }
                            }
                        });
                    }
                });


            }
        },
        save() {
            let url = "/employee/save";
            let $employeeId = $("#employeeId").val();
            if ($employeeId) {
                url = "/employee/update?cmd=_update";
            }
            editForm.form('submit', {
                url: url,
                //提交之前的操作
                onSubmit: function () {
                    return $(this).form('validate');
                },
                //提交完成后，接收后台返回的数据，并操作
                success: function (data) {
                    let result = JSON.parse(data);
                    if (result.success) {
                        //如果保存成功，就重新加载数据
                        employeeGrid.datagrid("reload");
                    } else {
                        //没有保存成功的话，就提示用户
                        $.messager.alert('错误', `保存失败，原因是:${result.msg}`, 'error');
                    }
                    mymethod.close();
                }
            });
        },
        update() {
            let row = employeeGrid.datagrid("getSelected");
            //如果用户没有选中行
            if (!row) {
                $.messager.alert("警告", "请选中一行数据再修改！", "warning");
                return;
            } else {
                editForm.form("clear");
                //禁用密码框，并让其失效
                $("*[data-edit]").hide();
                $("*[data-edit] input").validatebox("disable");
                //解决部门不能回显的问题
                if (row.department) {
                    //row对象增加一个department.id的属性
                    row['department.id'] = row.department.id;
                }
                //数据回显
                editForm.form("load", row);
                employeeDialog.dialog("center").dialog("open");
            }
        },
        search() {
            /**
             * serializeObject是easyui/plugin/jquery.jdirk.js下的方法，
             * 功能就是拿到一个form表单中的所有数据，（根据name属性）封装成json对象
             */
            let params = searchForm.serializeObject();
            employeeGrid.datagrid("load", params);/*重新加载数据（重新发送请求）*/
        },
        close() {
            employeeDialog.dialog("close");
        }
    };

    /**
     * 双击单元格的时候，直接编辑该单元格的字段的内容
     */
    employeeGrid.datagrid({
        onDblClickCell: function (index, field, value) {
            employeeGrid.datagrid('beginEdit', index);
            let ed = employeeGrid.datagrid('getEditor', {index: index, field: field});
            $(ed.target).focus();
        }/*,
        //双击行的时候修改当前条数据
        onDblClickRow: function (index, row) {
            editForm.form("clear");
            //禁用密码框，并让其失效
            $("*[data-edit]").hide();
            $("*[data-edit] input").validatebox("disable");
            //解决部门不能回显的问题
            if (row.department) {
                //row对象增加一个department.id的属性
                row['department.id'] = row.department.id;
            }
            //数据回显
            editForm.form("load", row);
            employeeDialog.dialog("center").dialog("open");
        }*/
    });

    //绑定相应的事件 : 与右键菜单冲突
    $(window).keydown(function (event) {
        switch (event.keyCode) {
            case 46:
                mymethod.del();
                break;
            case 13:
                mymethod.update();
                break;
            case 9:
                mymethod.add();
                break;
        }
    });

    //给回收站图标绑定事件
    $("#recycle").bind("click", function () {
        //点击打开dialog的时候就刷新数据
        $("#recycleGrid").datagrid("load");
        $("#recycleDialog").dialog({
            title: '回收站',
            width: 1000,
            height: 350,
            closed: false,
            cache: false,
            modal: true,
            openAnimation: "show",
            toolbar: [{
                text: '解除禁用',
                iconCls: 'icon-edit',
                handler: function () {
                    let rows = $("#recycleGrid").datagrid("getSelections");
                    //如果用户没有选中行
                    if (!rows) {
                        $.messager.alert("警告", "请至少选中一行数据再进行操作！", "warning");
                        return;
                    } else {
                        /*如果已经选中，提示是否确认进行删除操作*/
                        $.messager.confirm('确认', `您确认想要恢复这${rows.length}条记录吗？`, function (r) {
                            if (r) {
                                for (let i = 0; i < rows.length; i++) {
                                    $.get('/employee/recover', {id: rows[i].id}, function (result) {
                                        if (result.success) {
                                            $("#recycleGrid").datagrid("reload");
                                            employeeGrid.datagrid("reload");
                                        } else {
                                            $.messager.alert("错误", "恢复失败，原因：" + result.msg, "error")
                                        }
                                        //关闭对话框
                                        $("#recycleDialog").dialog("close");
                                    });
                                }
                            }
                        });
                    }
                }
            }]
        });
    });
});