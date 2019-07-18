/**
 * User: Chenyogie
 * Date: 
**/
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

function showMenu(e, index, row) {
    //选中这个行
    $("#supplierGrid").datagrid("selectRow", index);
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

$(function () {

    /*为每一个带有data-method属性的a标签绑定click事件*/
    $("a[data-method]").on("click", function () {
        /*获取方法的名称*/
        let methodName = $(this).data("method");
        /*调用方法*/
        window.mymethod[methodName]();
    });

    /*拿到常用的组件*/
    let supplierGrid = $("#supplierGrid");
    let searchForm = $("#searchForm");
    let supplierDialog = $("#supplierDialog");
    let editForm = $("#editForm");

    /*方法的定义*/
    mymethod = {
        add() {
            $("*[data-edit]").show();
            $("*[data-edit] input").validatebox("enable");
            //先清空
            editForm.form("clear");
            supplierDialog.dialog("center").dialog("open");
        },
        del() {//多行删除
            /*let row = supplierGrid.datagrid("getSelected");*/
            let rows = supplierGrid.datagrid("getSelections");
            //如果用户没有选中行
            if (!rows) {
                $.messager.alert("警告", "请至少选中一行数据再删除！", "warning");
                return;
            } else {
                /*如果已经选中，提示是否确认进行删除操作*/
                $.messager.confirm('确认', `您确认想要删除这${rows.length}条记录吗？`, function (r) {
                    if (r) {
                        for (let i = 0; i < rows.length; i++) {
                            $.get('/supplier/delete', {id: rows[i].id}, function (result) {
                                if (result.success) {
                                    supplierGrid.datagrid("reload");
                                } else {
                                    $.messager.alert("错误", "删除失败，原因：+" + result.msg, "error")
                                }
                                //关闭对话框
                                mymethod.close();
                            });
                        }
                    }
                });
            }
        },
        save() {
            let url = "/supplier/save";
            let $supplierId = $("#supplierId").val();
            if ($supplierId) {
                url = "/supplier/update?cmd=_update";
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
                        supplierGrid.datagrid("reload");
                    } else {
                        //没有保存成功的话，就提示用户
                        $.messager.alert('错误', `保存失败，原因是:${result.msg}`, 'error');
                    }
                    mymethod.close();
                }
            });
        },
        update() {
            let row = supplierGrid.datagrid("getSelected");
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
                supplierDialog.dialog("center").dialog("open");
            }
        },
        search() {
            /**
             * serializeObject是easyui/plugin/jquery.jdirk.js下的方法，
             * 功能就是拿到一个form表单中的所有数据，（根据name属性）封装成json对象
             */
            let params = searchForm.serializeObject();
            supplierGrid.datagrid("load", params);/*重新加载数据（重新发送请求）*/
        },
        close() {
            supplierDialog.dialog("close");
        }
    };

    /**
     * 双击单元格的时候，直接编辑该单元格的字段的内容
     */
    supplierGrid.datagrid({
        onDblClickCell:function (index, field, value) {
            supplierGrid.datagrid('beginEdit', index);
            let ed = supplierGrid.datagrid('getEditor', {index:index,field:field});
            $(ed.target).focus();
        }
        /*//双击行的时候修改当前条数据
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
            supplierDialog.dialog("center").dialog("open");
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
    //绑定相应的事件 : 与右键菜单冲突
    /*$("body").bind('keydown', 'del', window.mymethod.del);
    $(document).bind('keydown', 'Shift+1', window.mymethod.add);
    $(document).bind('keydown', 'Shift+2', window.mymethod.update);*/

});