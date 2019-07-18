<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp" %>
    <link rel='stylesheet' type='text/css' href='/css/import/googleapis.css'>
    <link rel="stylesheet" type="text/css" href="/css/import/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/import/default.css">
    <link rel="stylesheet" href="/css/import/demo.css">
    <link rel="stylesheet" href="/css/import/dropify.min.css">
    <style>
        .mysub {
            display: block;
            width: 343px;
            margin: 0 auto 10px auto;
            padding: 10px;
        }
    </style>
</head>
<body>

<article class="htmleaf-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <form action="/import/empxlsx" method="post" enctype="multipart/form-data">
                    <label for="input-file-french-1">"选择文件"</label>
                    <input type="file" id="input-file-french-1" class="dropify-fr" name="empFile"/>
                    <button class="mysub" style="display:block;width:80px;">提交</button>
                </form>
            </div>
        </div>
    </div>
</article>

<%--<script src="/js/import/jquery-2.1.1.min.js"></script>--%>
<script src="/js/import/dropify.min.js"></script>
<script>
    $(document).ready(function () {
        // Basic
        $('.dropify').dropify();

        // Translated
        $('.dropify-fr').dropify({
            messages: {
                'default': '点击或拖拽文件到这里',
                'replace': '点击或拖拽文件到这里来替换文件',
                'remove': '移除文件',
                'error': '对不起，你上传的文件太大了'
            }
        });

        // Used events
        var drEvent = $('.dropify-event').dropify();

        drEvent.on('dropify.beforeClear', function (event, element) {
            return confirm("Do you really want to delete \"" + element.filename + "\" ?");
        });

        drEvent.on('dropify.afterClear', function (event, element) {
            alert('File deleted');
        });
    });
</script>
</body>
</html>
