<%--
  User: chenyogie
  Date: 2019/7/6
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>employee.jsp</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/employee.js"></script>
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
<table id="employeeGrid" class="easyui-datagrid" fit="true"
       <%--
            实现多行删除：
                singleSelect:false 取消单行选中
                checkOnSelect:true 多行复选框
       --%>
       data-options="url:'/employee/findPage',fitColumns:true,
       singleSelect:false,checkOnSelect:true,onRowContextMenu:showMenu,
       pagination:true,toolbar:'#gridTolls',enableHeaderClickMenu:'true'">
    <thead>
        <tr>
            <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>
            <th data-options="field:'id',width:20" align="center">编号</th>
            <th data-options="field:'headImage',width:50,formatter:imgFormat" align="center">头像</th>
            <th data-options="field:'username',width:40" align="center" sortable="true">姓名</th>
            <th data-options="field:'password',width:100" align="center">密码</th>
            <th data-options="field:'email',width:100" align="center">邮箱</th>
            <th data-options="field:'age',width:20" align="center" sortable="true">年龄</th>
            <th data-options="field:'department',width:30,formatter:deptFormat" align="center" sortable="true">部门</th>
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
        姓名: <input name="username" class="easyui-textbox" style="width:80px">
        邮箱: <input name="email" class="easyui-textbox" style="width:80px">
        <%--
            panelHeight：高度自动，根据下拉数据的数据量设置合适的高度
        --%>
        部门: <input name="department_id" class="easyui-combobox" panelHeight="auto"
                   data-options="valueField:'id',textField:'name',url:'/util/findDepts'"/>
        <a data-method="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
<%--对话框--%>
<div id="employeeDialog" class="easyui-dialog" style="width:345px;padding-left: 35px;padding-right: 35px;padding-top: 15px;"
     data-options="title:'编辑功能',buttons:'#editBtn',modal:true,closed:true">
    <form id="editForm" method="post">
        <%--当修改的时候，把id传到后台--%>
        <input id="employeeId" type="hidden" name="id">
        <table>
            <tr>
                <td><label>姓&emsp;&emsp;名:</label></td>
                <td><input class="easyui-validatebox" type="text" name="username"
                           data-options="validType:'checkName',required:true"/></td>
            </tr>
            <tr data-edit="true">
                <td><label>密&emsp;&emsp;码:</label>
                <td><input class="easyui-validatebox" type="password" name="password" id="password"
                           data-options="required:true"/></td>
            </tr>
            <tr data-edit="true">
                <td><label>确定密码:</label></td>
                <td><input class="easyui-validatebox" type="password" name="confirmPassword"
                           validType="equals['password','id']" data-options="required:true"/></td>
            </tr>
            <tr>
                <td><label>邮&emsp;&emsp;箱:</label></td>
                <td><input class="easyui-validatebox" type="email" name="email"
                           data-options="validType:'email',required:true"/></td>
            </tr>
            <tr>
                <td><label>年&emsp;&emsp;龄:</label></td>
                <td><input class="easyui-validatebox" type="text" name="age"
                           data-options="validType:'integerRange[10,100]'"/></td>
            </tr>
            <tr>
                <td><label>部&emsp;&emsp;门:</label></td>
                <td><input name="department.id" class="easyui-combobox" panelHeight="auto"
                           data-options="valueField:'id',textField:'name',url:'/util/findDepts',required:true"/></td>
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
