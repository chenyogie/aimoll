<%--
  User: chenyogie
  Date: 2019/7/6
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--映入shiro的标签--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>main.jsp</title>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body class="easyui-layout" fit="true" oncontextmenu="doNothing()">
<div id="beau_title" data-options="region:'north',split:true">
    <%--超级社区智能商城--%>
    <div style="color: white;text-align: right;padding-right: 30px;">
        <%--
            principal:目前存放的是用户名
        --%>
        <h6>欢迎您，<shiro:principal property="username"/><a href="/logout">注销</a></h6>
    </div>
</div>
<div data-options="region:'west',title:'菜单选项',split:true" style="width:230px;">
    <ul id="treeMenu"></ul>
</div>
<%--
    ,onContextMenu:showTabMenu
--%>
<div id="mainTabs" class="easyui-tabs" data-options="region:'center'">
    <div title="首页" style="padding:20px;display:none;">
        欢迎来到超级社区智能商城系统！
    </div>
</div>
<div id="tabMenu" class="easyui-menu" style="width:80px;">
    <div data-options="id:'1',iconCls:'icon-close'">关闭本选项卡</div>
    <div data-options="id:'2',iconCls:'icon-close'">关闭所有选项卡</div>
</div>
<script>

    //阻止浏览器原有的右键菜单弹出
    function doNothing() {
        window.event.returnValue = false;
        return false;
    }

    $(function () {

        let mainTabs = $("#mainTabs");

        $('#treeMenu').tree({
            url: "/util/findMenusByUser",
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
                    content: '<iframe src='+node.url+' height="100%" width="100%" scrolling="auto"></iframe>'
                });
            }
        });

        mainTabs.tabs({
            /**
             * 右键点击选项卡面板触发事件
             * @param e 事件对象
             * @param title 选项卡标题
             * @param index 选项卡索引
             */
            onContextMenu: function (e, title, index) {
                let leftx = e.pageX;
                let lefty = e.pageY;
                //右键在哪里点击，就在哪里显示右键菜单
                $('#tabMenu').menu('show', {
                    left: leftx,
                    top: lefty,
                    onClick: function (item) {
                        switch (item.id) {
                            case "1":
                                closeSelf(index);
                                break;
                            case "2":
                                closeAll();
                                break;
                        }
                    }
                });
            }
        });
    });

    //关闭本选项卡
    function closeSelf(index) {
        let mainTabs = $("#mainTabs");
        if (index != 0) {
            mainTabs.tabs("close", index);
        }
    }
    /**
     * 关闭所有选项卡
     * @param index
     */
    function closeAll() {
        let mainTabs = $("#mainTabs");
        let ts = mainTabs.tabs("tabs");
        let len = ts.length;
        /**
         * 在循环中，终止条件不能使用直接使用ts.length
         * 因为关闭一个tab选项卡，ts数组的长度就发生了变化
         **/
        for (let i = 1; i < len; i++) {
            console.log(ts.length)
            $("#mainTabs").tabs("close", 1);
        }
        /*for (let i = ts.length; i >=1 ; i--) {
            console.log(ts.length)
            $("#mainTabs").tabs("close", 1);
        }*/
    }
</script>
</body>
</html>
