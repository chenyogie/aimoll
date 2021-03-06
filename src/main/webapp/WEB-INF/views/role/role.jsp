<%--
  User: Chenyogie
  Date: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>role.jsp</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/role.js"></script>
    <%--引入easyui扩展库--%>
    <link rel="stylesheet" href="http://www.easyui-extlib.com/Content/icons/icon-standard.css"/>
    <link rel="stylesheet"
          href="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.css"/>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/menu/jeasyui.extensions.menu.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.columnToggle.js"></script>

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
<table id="roleGrid" class="easyui-datagrid" fit="true"
       data-options="url:'/role/findPage',fitColumns:true,
       singleSelect:false,checkOnSelect:true,onRowContextMenu:showMenu,
       pagination:true,toolbar:'#gridTolls',enableHeaderClickMenu:'true'">
    <thead>
    <tr>
        <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>
        <th data-options="field:'name',width:100" align="center">名称</th>
        <th data-options="field:'sn',width:100" align="center">编码</th>
        <th data-options="field:'permissions',width:100,formatter:permsFormat" align="center">权限</th>
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
        名称: <input name="name" class="easyui-textbox" style="width:80px">
        <a data-method="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
<%--对话框--%>
<div id="roleDialog" class="easyui-dialog" style="width:900px;"
     data-options="title:'编辑功能',buttons:'#editBtn',modal:true,closed:true">
    <form id="editForm" method="post">
        <%--当修改的时候，把id传到后台--%>
        <input id="roleId" type="hidden" name="id">
        <table>
            <tr>
                <td>
                    名称 : <input class="easyui-validatebox" type="text" name="name"
                           data-options="required:true"/>&emsp;
                    编码 : <input class="easyui-validatebox" type="text" name="sn"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="cc" class="easyui-layout" style="width:900px;height:300px;">
                        <div data-options="region:'west',title:'当前用户权限'" style="width:450px;">
                            <table id="userPermissionGrid"></table>
                        </div>
                        <div data-options="region:'center',title:'系统所有权限'">
                            <table id="allPermissionGrid"></table>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </form>
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