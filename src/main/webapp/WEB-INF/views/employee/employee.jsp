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
</head>
<body>
<table id="employeeGrid" class="easyui-datagrid" fit="true"
       data-options="url:'/employee/findPage',fitColumns:true,singleSelect:true,pagination:true,toolbar:'#gridTolls'">
    <thead>
        <tr>
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
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true">剪切</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <%--搜索部分--%>
    <form id="searchForm">
        姓名: <input name="username" class="easyui-textbox" style="width:80px">
        邮箱: <input name="email" class="easyui-textbox" style="width:80px">
        <%--
            panelHeight：高度自动，根据下拉数据的数据量设置合适的高度
        --%>
        部门: <input id="cc" name="department_id" class="easyui-combobox" panelHeight="auto"
                  data-options="valueField:'id',textField:'name',url:'/util/findDepts'" />
        <a data-method="search" href="#"  class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
</body>
</html>
