<%--
  User: Chenyogie
  Date: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>purchasebillitem.jsp</title>
    <%@include file="../head.jsp" %>
    <script src="/easyui/plugin/datagrid-groupview.js"></script>
    <%--引入highcharts--%>
    <script src="/js/highcharts/code/highcharts.js"></script>
    <script src="/js/highcharts/code/highcharts-3d.js"></script>
    <script src="/js/highcharts/code/modules/exporting.js"></script>
    <script src="/js/highcharts/code/modules/export-data.js"></script>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/purchasebillitem.js"></script>
    <style>
        #editForm table tr td {
            padding: 3px;
        }
        .datagrid-row-selected {
            background-color: #0092DC;
        }
    </style>
</head>
<body>
<table id="purchasebillitemGrid"></table>
<%--datagrid顶部工具栏--%>
<div id="gridTools" style="padding:5px;height:auto">
    <%--搜索部分--%>
    <form id="searchForm">
        日期:
        <input name="beginDate" class="easyui-datebox" style="width:120px">
        &nbsp;-&nbsp;
        <input name="endDate" class="easyui-datebox" style="width:120px">
        状态:
        <select class="easyui-combobox" name="status" panelHeight="auto" style="width: 120px;">
            <option value="-1">作废</option>
            <option value="0">待审</option>
            <option value="1">已审</option>
        </select>
        分组:
        <select class="easyui-combobox" name="groupBy" panelHeight="auto" style="width:120px;">
            <option value="0">供应商</option>
            <option value="1">采购员</option>
            <option value="2">月份</option>
        </select>
        <a data-method="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a data-method="chartMethod" href="#" class="easyui-linkbutton" iconCls="icon-search">查看图表</a>
    </form>
</div>
<%--high图表框--%>
<div id="chartDialog" class="easyui-dialog" title="功能编辑" style="width:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <div id="container" style="height: 400px"></div>
</div>
</body>
</html>