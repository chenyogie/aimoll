<%--
  User: chenyogie
  Date: 2019/7/20
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>在线用户</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/onlineuser.js"></script>
</head>
<body>
<table id="onlineUserGrid" class="easyui-datagrid" fit="true"
<%--
     实现多行删除：
         singleSelect:false 取消单行选中
         checkOnSelect:true 多行复选框
--%>
       data-options="url:'/onlineuser/findAll',fitColumns:true,
       singleSelect:false,checkOnSelect:true,
       pagination:true,enableHeaderClickMenu:'true'">
    <thead>
    <tr>
        <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>
        <th data-options="field:'id',width:50" align="center">唯一标识</th>
        <th data-options="field:'username',width:40" align="center">登陆用户</th>
        <th data-options="field:'host',width:50" align="center">登陆地址</th>
        <th data-options="field:'lastAccessTime',width:50" align="center">上一次操作时间</th>
    </tr>
    </thead>
</table>
</body>
</html>
