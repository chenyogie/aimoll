/**
 * User: Chenyogie
 * Date: 
**/
 //阻止浏览器原有的右键菜单弹出
function doNothing() {
    window.event.returnValue = false;
    return false;
}

function objFormat(value, row, index) {
    return value ? value.name || value.username: "";
}

function statusFormat(value, row, index) {
    if(value==-1){
        return "<span style='color: grey'><s>&nbsp;已&emsp;删&nbsp;</s></span>";
    }else if(value==0){
        return "<span style='color: red'>&emsp;待&emsp;审&emsp;</span>";
    }else if(value==1){
        return "<span style='color: green'>&emsp;已&emsp;审&emsp;</span>";
    }
}

function showMenu(e, index, row) {
    //选中这个行
    $("#purchasebillGrid").datagrid("selectRow", index);
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
    let purchasebillGrid = $("#purchasebillGrid");
    let searchForm = $("#searchForm");
    let purchasebillDialog = $("#purchasebillDialog");
    let editForm = $("#editForm");

    /*方法的定义*/
    mymethod = {
        add() {
            $("*[data-edit]").show();
            $("*[data-edit] input").validatebox("enable");
            //先清空
            editForm.form("clear");
            //清空grid中的数据
            dg.datagrid("loadData",[]);
            purchasebillDialog.dialog("center").dialog("open");
        },
        del() {//多行删除
            /*let row = purchasebillGrid.datagrid("getSelected");*/
            let rows = purchasebillGrid.datagrid("getSelections");
            //如果用户没有选中行
            if (!rows) {
                $.messager.alert("警告", "请至少选中一行数据再删除！", "warning");
                return;
            } else {
                /*如果已经选中，提示是否确认进行删除操作*/
                $.messager.confirm('确认', `您确认想要删除这${rows.length}条记录吗？`, function (r) {
                    if (r) {
                        for (let i = 0; i < rows.length; i++) {
                            $.get('/purchasebill/delete', {id: rows[i].id}, function (result) {
                                if (result.success) {
                                    purchasebillGrid.datagrid("reload");
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
            let url = "/purchasebill/save";
            let $purchasebillId = $("#purchasebillId").val();
            if ($purchasebillId) {
                url = "/purchasebill/update?cmd=_update";
            }
            editForm.form('submit', {
                url: url,
                //提交之前的操作
                onSubmit: function (param) {
                    //将明细中的所有数据提交到后台,遍历所有行，将数据拼接到param中
                    var rows = dg.datagrid("getRows");
                    for(var i=0;i<rows.length;i++){
                        var row = rows[i];
                        //把值放到params中去
                        param[`items[${i}].product.id`] = row.product.id;
                        param[`items[${i}].num`] = row.num;
                        param[`items[${i}].price`] = row.price;
                        param[`items[${i}].descs`] = row.descs;
                    }
                    return $(this).form('validate');
                },
                //提交完成后，接收后台返回的数据，并操作
                success: function (data) {
                    let result = JSON.parse(data);
                    if (result.success) {
                        //如果保存成功，就重新加载数据
                        purchasebillGrid.datagrid("reload");
                    } else {
                        //没有保存成功的话，就提示用户
                        $.messager.alert('错误', `保存失败，原因是:${result.msg}`, 'error');
                    }
                    mymethod.close();
                }
            });
        },
        update() {
            let row = purchasebillGrid.datagrid("getSelected");
            //如果用户没有选中行
            if (!row) {
                $.messager.alert("警告", "请选中一行数据再修改！", "warning");
                return;
            } else {
                editForm.form("clear");
                //禁用密码框，并让其失效
                $("*[data-edit]").hide();
                $("*[data-edit] input").validatebox("disable");
                //回显
                // 供应商
                if(row.supplier){
                    row["supplier.id"] = row.supplier.id;
                }
                // 采购员
                if(row.buyer){
                    row["buyer.id"] = row.buyer.id;
                }
                //数据回显
                editForm.form("load", row);
                purchasebillDialog.dialog("center").dialog("open");

                //拿到这行数据中的items(明细)进行回显
                var items = [...row.items];
                dg.datagrid("loadData",items);
            }
        },
        search() {
            /**
             * serializeObject是easyui/plugin/jquery.jdirk.js下的方法，
             * 功能就是拿到一个form表单中的所有数据，（根据name属性）封装成json对象
             */
            let params = searchForm.serializeObject();
            purchasebillGrid.datagrid("load", params);/*重新加载数据（重新发送请求）*/
        },
        close() {
            purchasebillDialog.dialog("close");
        }
    };

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


    //获取控件
    var dg = $("#gridItems"),
        defaultRow = { id: "", product: "", productColor: "", productImg: "", num: 0, price: 0, amount: 0,descs:"" },
        insertPosition = "bottom";
    //明细的grid组件的初始化设置
    var dgInit = function () {
        //datagrid的列数据
        var getColumns = function () {
            var result = [];

            var normal = [
                {
                    field: 'product', title: '商品', width: 180,
                    editor: {
                        type: "combobox",
                        options: {
                            valueField:'id',
                            textField:'name',
                            panelHeight:"auto",
                            url:'/util/findProduct',
                            required: true
                        }
                    },
                    formatter(v,r,i){
                        return v?v.name:"";
                    }
                },
                {
                    field: 'productColor', title: '颜色', width: 80,
                    formatter(v,r,i){
                        if(r && r.product){
                            return `<div style='width: 20px;height: 20px;background-color:${r.product.color}'></div>`;
                        }
                    }
                },
                {
                    field: 'productImg', title: '图片', width: 100,
                    formatter(v,r,i){
                        if(r && r.product){
                            return  `<img src='${r.product.smallpic}' width="50px" height="50px" alt='没有图片' />`;
                        }
                    }
                },
                {
                    field: 'num', title: '数量', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            precision:2,
                            required: true
                        }
                    }
                },
                {
                    field: 'price', title: '价格', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            precision:2,
                            required: true
                        }
                    }
                },
                {
                    field: 'amount', title: '小计', width: 100,
                    formatter(v,r,i){
                        if(r && r.num && r.price){
                            return (r.num * r.price).toFixed(2);
                        }
                        return 0;
                    }
                },
                {
                    field: 'descs', title: '备注', width: 100,
                    editor: {
                        type: "text"
                    }
                }
            ];
            result.push(normal);

            return result;
        };
        //准备datagrid组件中的属性
        var options = {
            idField: "ID", //id的字段(唯一的)
            rownumbers: true, // 行号
            fitColumns: true, //列的自适应
            fit: true, //自适应咱们的父窗口
            border: true, //是否显示边框
            singleSelect: true,
            columns: getColumns(),
            toolbar:"#itemsTools",
            bodyCls:"bodyCls",
            //表示开启单元格编辑功能
            enableCellEdit: true
        };
        //创建datagrid组件
        dg.datagrid(options);
    };

    //拿到插入的那一行数据的索引
    var getInsertRowIndex = function () {
        return insertPosition == "top" ? 0 : dg.datagrid("getRows").length;
    }

    //定义了一个变量,这个变量也是一个方法
    var buttonBindEvent = function () {
        //添加一行数据
        $("#btnInsert").click(function () {
            var targetIndex = getInsertRowIndex(), targetRow = $.extend({}, defaultRow, { ID: $.util.guid() });
            dg.datagrid("insertRow", { index: targetIndex, row: targetRow });
            dg.datagrid("editCell", { index: 0, field: "Code" });
        });

        //删除一行数据
        $("#btnRemove").click(function () {
            //1.获取到选中的行(这一行的数据)
            var row = dg.datagrid("getSelected");
            if(row){
                var index = dg.datagrid("getRowIndex",row);
                dg.datagrid("deleteRow",index);
            }
        });
    };

    //把grid初始化与事务绑定完成
    dgInit();
    buttonBindEvent();

});