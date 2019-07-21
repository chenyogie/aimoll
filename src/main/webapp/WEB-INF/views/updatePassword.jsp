<%--
  User: chenyogie
  Date: 2019/7/20
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改密码</title>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" type="text/css" href="/css/login/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="/css/login/login.css">
    <style>
        button {
            background: #ff5f32;
            border-radius: 50%;
            border: 10px solid #222526;
            font-size: 0.9em;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            width: 85px;
            height: 85px;
            position: absolute;
            right: 95px;
            top: 280px;
            text-align: center;
            -webkit-transition: 0.5s ease;
            -moz-transition: 0.5s ease;
            -o-transition: 0.5s ease;
            -ms-transition: 0.5s ease;
            transition: 0.5s ease;
        }

        #mainup {
            float: left;
            width: 250px;
            height: 350px;
            padding: 10px 15px;
            position: relative;
            background: #555555;
            border-radius: 3px;
            margin-left: 140px;
        }

        lebel {
            margin-left: 100px;
            color: #91e8e1;
        }
    </style>
</head>
<body style="padding-top: 100px;">
<div id="loginform">
    <div id="mainup">
        <h1>修改密码</h1>
        <lebel>用&nbsp;户&nbsp;名：</lebel>
        <input type="text" name="username" id="username" required>
        <lebel>密&emsp;&emsp;码：</lebel>
        <input type="password" name="password" id="password" required>
        <lebel>确认密码：</lebel>
        <input type="password" name="newPassword" id="password1" required>
        <div>
            <button id="submitBtn">提交</button>
        </div>
    </div>
</div>
<script>

    $("#password1").blur(function () {
        let password = $("#password").val();
        let newPassword = $("#password1").val();
        if (password != newPassword) {
            $.messager.alert("警告", "您两次输入的密码不一致！")
        }
    });
    //当整个文档加载完成后执行
    $(function () {
        //给按钮绑定点击事件
        $("#submitBtn").on("click", function () {
            let username = $("#username").val();
            let password = $("#password").val();
            $.ajax({
                type: "POST",
                url: "/updatePassword",
                async: false,
                data: {username: username, password: password},
                success: function (data) {
                    //console.log(data)
                    if(data.success){
                        $.messager.show({
                            title:'提示',
                            msg:data.msg+'，即将跳转到登录页面。',
                            timeout:1500,
                            showType:'slide'
                        });
                        //2秒后触发
                        window.setTimeout(function () {
                            window.location.href="/login";
                        }, 3000);
                    }else{
                        $.messager.alert("警告",data.msg,"warrning");
                    }
                }
            });
        });
    })
</script>
</body>
</html>
