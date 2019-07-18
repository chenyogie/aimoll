<%--
  User: Chenyogie
  Date: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>purchasebill.jsp</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/purchasebill.js"></script>
    <%--引入easyui扩展库--%>
    <link rel="stylesheet" href="http://www.easyui-extlib.com/Content/icons/icon-standard.css"/>
    <link rel="stylesheet"
          href="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.css"/>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/menu/jeasyui.extensions.menu.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.columnToggle.js"></script>
    <script src="/easyui/plugin/jeasyui.extensions.datagrid.edit.cellEdit.js"></script>
    <script src="/easyui/plugin/jeasyui.extensions.datagrid.editors.js"></script>
    <script src="/easyui/plugin/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <style>
        #editForm table tr td {
            padding: 3px;
        }

        .datagrid-row-selected {
            background-color: #0092DC;
        }
    </style>
</head>
<body oncontextmenu="doNothing()">
<table id="purchasebillGrid" class="easyui-datagrid" fit="true"
       data-options="url:'/purchasebill/findPage',fitColumns:true,
       singleSelect:false,checkOnSelect:true,onRowContextMenu:showMenu,
       pagination:true,toolbar:'#gridTolls',enableHeaderClickMenu:'true'">
    <thead>
    <tr>
        <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>

        <th data-options="field:'buyer',width:100,formatter:objFormat" align="center">采购员</th>
        <th data-options="field:'vdate',width:100" align="center">交易时间</th>
        <th data-options="field:'status',width:100,formatter:statusFormat" align="center">状态</th>
        <th data-options="field:'supplier',width:100,formatter:objFormat" align="center">供应商</th>
        <th data-options="field:'totalamount',width:100" align="center">总金额</th>
        <th data-options="field:'totalnum',width:100" align="center">总数量</th>
        <th data-options="field:'inputUser',width:100,formatter:objFormat" align="center">录入员</th>
        <%--<th data-options="field:'inputtime',width:100" align="center">录入时间</th>--%>
        <%--<th data-options="field:'auditortime',width:100" align="center">审核时间</th>--%>
        <%--<th data-options="field:'auditor',width:100,formatter:objFormat" align="center">审核人</th>--%>
    </tr>
    </thead>
</table>
<%--datagrid顶部工具栏--%>
<div id="gridTolls" style="padding:5px;height:auto">
    <%--操作按钮--%>
    <div style="margin-bottom:5px">
        <a href="#" data-method="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#" data-method="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" data-method="del" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <%--搜索部分--%>
    <form id="searchForm">
        日期:
        <input name="beginDate" class="easyui-datebox" style="width:120px">
        &nbsp;-&nbsp;
        <input name="endDate" class="easyui-datebox" style="width:120px">
        状态:
        <select class="easyui-combobox" name="status" panelHeight="auto" style="width: 120px;">
            <option selected="selected">--选择条件--</option>
            <option value="-1">作废</option>
            <option value="0">待审</option>
            <option value="1">已审</option>
        </select>
        <a data-method="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
<%--对话框--%>
<div id="purchasebillDialog" class="easyui-dialog"
     style="width:600px;padding-left: 10px;padding-right: 10px;padding-top: 10px;"
     data-options="title:'编辑功能',buttons:'#editBtn',modal:true,closed:true">

    <form id="editForm" method="post">
        <%--当修改的时候，把id传到后台--%>
        <input id="purchasebillId" type="hidden" name="id">
        <table>
            <tr>
                <td>
                    <label>交易时间:</label>
                    <input class="easyui-datebox" type="text" name="vdate"/>
                </td>
                <td>
                    <label>供应商:</label>
                    <input class="easyui-combobox" type="text" name="supplier.id" panelHeight="auto"
                           data-options="valueField:'id',textField:'name',url:'/util/findAllSupplier'"/>
                </td>
                <td>
                    <label>采购员:</label>
                    <input class="easyui-combobox" type="text" name="buyer.id"
                           data-options="valueField:'id',textField:'username',url:'/util/findBuyer'"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <table id="gridItems"></table>
                </td>
            </tr>
        </table>
    </form>
</div>
<%----%>
<div id="itemBtns">
    <a id="btnInsert" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增一行</a>
    <a id="btnRemove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除一行</a>
</div>
<div id="editBtn">
    <a data-method="save" href="#" class="easyui-linkbutton">保存</a>
    <a data-method="close" href="#" class="easyui-linkbutton">关闭</a>
</div>
<div id="gridMenu" class="easyui-menu" style="width:80px;">
    <div data-options="iconCls:'icon-add'">添加</div>
    <div data-options="iconCls:'icon-edit'">修改</div>
    <div data-options="iconCls:'icon-remove'">删除</div>
</div>
</body>
</html>