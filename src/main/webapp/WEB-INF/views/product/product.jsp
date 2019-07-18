<%--
  User: Chenyogie
  Date: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
    <title>product.jsp</title>
    <%@include file="../head.jsp" %>
    <%--自定义的js要在head.jsp后引入，因为head.jsp中有jquery的引入,自定义的js如果要使用jquey，就需要之后引入--%>
    <script src="/js/model/product.js"></script>
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
<table id="productGrid" class="easyui-datagrid" fit="true"
       data-options="url:'/product/findPage',fitColumns:true,
       singleSelect:false,checkOnSelect:true,onRowContextMenu:showMenu,
       pagination:true,toolbar:'#gridTolls',enableHeaderClickMenu:'true',onLoadSuccess:showImg">
    <thead>
    <tr>
        <th data-options="field:'',checkbox:true,width:50,checkbox:true" align="center"></th>
        <th data-options="field:'name',width:100" align="center">产品名称</th>
        <th data-options="field:'color',width:30,formatter:colorFormat" align="center">颜色</th>
        <%--<th data-options="field:'pic',width:100,formatter:imgFormat" align="center">图片</th>--%>
        <th data-options="field:'smallpic',width:100,formatter:imgFormat" align="center">图片</th>
        <th data-options="field:'costprice',width:100" align="center">成本价</th>
        <th data-options="field:'saleprice',width:100" align="center">售价</th>
        <th data-options="field:'producttype',width:100,formatter:typeFormat" align="center">产品类型</th>
        <th data-options="field:'unit',width:100,formatter:unitFormat" align="center">度量单位</th>
        <th data-options="field:'brand',width:100,formatter:brandFormat" align="center">品牌</th>
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
<div id="productDialog" class="easyui-dialog"
     style="width:345px;padding-left: 35px;padding-right: 35px;padding-top: 15px;"
     data-options="title:'编辑功能',buttons:'#editBtn',modal:true,closed:true">
    <form id="editForm" method="post" enctype="multipart/form-data">
        <%--当修改的时候，把id传到后台--%>
        <input id="productId" type="hidden" name="id">
        <table>
            <tr>
                <td>
                    <label>产品名称:</label>
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="name"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品颜色:</label>
                </td>
                <td>
                    <input class="easyui-validatebox" type="color" name="color"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品图片:</label>
                </td>
                <td>
                    <input class="easyui-filebox" name="lgPic" data-options="buttonText:'选择文件'" style="width:100%">
                </td>
            </tr>
            <tr>
                <td>
                    <label>缩略图:</label>
                </td>
                <td>
                    <input class="easyui-filebox" name="smPic" data-options="buttonText:'选择文件'" style="width:100%">
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品成本:</label>
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="costprice"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品售价:</label>
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="saleprice"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品品牌:</label>
                </td>
                <td>
                    <input class="easyui-combobox" type="text" name="brand.id" panelHeight="auto"
                           data-options="required:true,valueField:'id',textField:'name',url:'/util/findBrands'"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>数量单位:</label>
                </td>
                <td>
                    <input class="easyui-combobox" type="text" name="unit.id" panelHeight="auto"
                           data-options="required:true,valueField:'id',textField:'name',url:'/util/findUnits'"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>产品分类:</label>
                </td>
                <td>
                    <input id="productParentBrand" class="easyui-combobox" type="text" panelHeight="auto" name="producttype.parent.id"
                           data-options="required:true,valueField:'id',textField:'name',
                           url:'/util/findTypeParent'"/>
                </td>
            <tr>
                <td>
                    <label></label>
                </td>
                <td>
                    <input id="productBrand" class="easyui-combobox" type="text" name="producttype.id" panelHeight="auto"
                           data-options="required:true,valueField:'id',textField:'name',url:'/util/findTypeChildren'"/>
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