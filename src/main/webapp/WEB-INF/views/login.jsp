<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset='UTF-8'>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" type="text/css" href="/css/login/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="/css/login/login.css">
    <script>
        //判断当前页面是否是顶层页面
        if(top != window){
            //window.top.location.href = "/login";
            window.top.location.href = window.location.href;
        }

        /**
         * 回车提交表单
         */
        /*$(document.documentElement).on("keyup", function(event) {
            //console.debug(event.keyCode);
            console.debug(event);

            var keyCode = event.keyCode;
            if (keyCode === 13) { // 捕获回车
                submitForm(); // 提交表单
            }
        });*/

        //当整个文档加载完成后执行
        $(function () {
            //给按钮绑定点击事件
            $("#submitBtn").on("click",function () {
                let username = $("#username").val();
                let password = $("#password").val();
                let activeCode = $("#activeCode").val();
                $.ajax({
                    type:"POST",
                    url:"/login",
                    async:false,
                    data:{username:username,password:password,activeCode:activeCode},
                    success:function (data) {
                        //console.log(data)
                        if(data.success){
                            window.location.href="/main";
                        }else{
                            $.messager.alert("警告",data.msg,"warrning");
                        }
                    }
                });
            });
        })
        function changeImg(img){
            img.src = img.src + "?/time=" + new Date().getTime();
        }
    </script>
</head>
<body style="padding-top: 100px;">
<div id="loginform">
    <div id="facebook">
        <img id="wechatImg" src="/getImg" onclick="changeImg(this)" width="150px" height="40px">
        <!-- <i class="fa fa-facebook"></i> -->
        <div id="connect">验证码</div>
    </div>
    <div id="mainlogin">
        <div id="or">or</div>
        <h1>超级社区管理系统</h1>
        <%--<form action="post">--%>
        <div>
            <input type="text" name="username" id="username" placeholder="username or email" value="admin" required>
            <input type="password" name="password" id="password" placeholder="password" value="admin" required>
            <input type="text" name="activeCode" id="activeCode" placeholder="请输入验证码">
            <button id="submitBtn">
                <i class="fa fa-arrow-right"></i>
            </button>
        </div>
        <%--</form>--%>
        <div id="note">
            <%--<a href="#">忘记密码?</a>--%>
            <a href="/turnToUpdatePassword">去修改密码</a>
        </div>
    </div>
</div>
</body>
</html>