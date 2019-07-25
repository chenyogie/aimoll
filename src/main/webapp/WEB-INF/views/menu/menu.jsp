<%--
  User: Chenyogie
  Date: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>menu.jsp</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/menu.js"></script>
    <%--引入easyui扩展库--%>
    <link rel="stylesheet" href="http://www.easyui-extlib.com/Content/icons/icon-standard.css" />
    <link rel="stylesheet" href="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.css" />
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/menu/jeasyui.extensions.menu.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.columnToggle.js"></script>

    <style>
        #editForm table tr td{
            padding: 3px;
        }
        .datagrid-row-selected{
            background-color:#0092DC;
        }
    </style>
</head>
<body oncontextmenu="doNothing()">
<table id="menuGrid" class="easyui-datagrid" fit="true"
       data-options="url:'/menu/findPage',fitColumns:true,
       singleSelect:false,checkOnSelect:true,onRowContextMenu:showMenu,
       pagination:true,toolbar:'#gridTolls',enableHeaderClickMenu:'true'">
    <thead>
        <tr>
            <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>
                                            <th data-options="field:'name',width:100" align="center">name</th>
                                            <th data-options="field:'url',width:100" align="center">url</th>
                                            <th data-options="field:'icon',width:100" align="center">icon</th>
                                            <th data-options="field:'parentId',width:100" align="center">parentId</th>
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
<div id="menuDialog" class="easyui-dialog" style="width:345px;padding-left: 35px;padding-right: 35px;padding-top: 15px;"
     data-options="title:'编辑功能',buttons:'#editBtn',modal:true,closed:true">
    <form id="editForm" method="post">
        <%--当修改的时候，把id传到后台--%>
        <input id="menuId" type="hidden" name="id">
        <table>
                        <tr>
            <td>
                <label>name:</label>
            </td>
            <td>
                <input class="easyui-validatebox" type="text" name="name"
                      data-options="required:true"/>
            </td>
        </tr>
                        <tr>
            <td>
                <label>url:</label>
            </td>
            <td>
                <input class="easyui-validatebox" type="text" name="url"
                      data-options="required:true"/>
            </td>
        </tr>
                        <tr>
            <td>
                <label>icon:</label>
            </td>
            <td>
                <input class="easyui-validatebox" type="text" name="icon"
                      data-options="required:true"/>
            </td>
        </tr>
                        <tr>
            <td>
                <label>parentId:</label>
            </td>
            <td>
                <input class="easyui-validatebox" type="text" name="parentId"
                      data-options=""/>
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