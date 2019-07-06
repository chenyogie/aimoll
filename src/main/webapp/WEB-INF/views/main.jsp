<%--
  User: chenyogie
  Date: 2019/7/6
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>main.jsp</title>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body class="easyui-layout" fit="true">
<div id="beau_title" data-options="region:'north',split:true">
    <%--超级社区智能商城--%>
</div>
<div data-options="region:'west',title:'West',split:true" style="width:230px;">
    <ul id="treeMenu"></ul>
</div>
<div id="mainTabs" class="easyui-tabs" data-options="region:'center'">
    <div title="首页" style="padding:20px;display:none;">
        欢迎来到超级社区智能商城系统！
    </div>
</div>
<script>
    $(function () {

        let mainTabs = $("#mainTabs");

        $('#treeMenu').tree({
            url: "/josn/treeMenu.json",
            onClick: function (node) {
                /*如果节点没有url，那么就是父节点，不需要开启一个选项卡*/
                if (!node.url)
                    return;
                /*如果节点对应的选项卡已经被打开，选中即可*/
                if (mainTabs.tabs("exists", node.text)) {
                    mainTabs.tabs("select", node.text);
                    return;
                }
                /*新建选项卡，*/
                mainTabs.tabs("add", {
                    title: node.text,
                    closable: true,
                    content: '<iframe src="/employee/index" height="100%" width="100%" scrolling="auto"></iframe>'
                });
            }
        });

    })
</script>
</body>
</html>
