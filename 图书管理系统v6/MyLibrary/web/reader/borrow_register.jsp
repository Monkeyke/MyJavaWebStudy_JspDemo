<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-table.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap-table.js"></script>
    <script src="../bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" href="../public/layui/css/layui.css"  media="all">
    <style>
        .layui-table,.layui-table-view{
            margin: 0 0px;
        }
    </style>

</head>
<body>
<script src="../public/layui/layui.js" charset="utf-8"></script>
<!-- 表单 -->
<% if(session.getAttribute("reader")==null){%>
<script>
    location.href = "../RegisterReader.html";
</script>
<%
    }
%>
<table class="layui-hide" id="cardTable" lay-filter="formFilter"></table>

</body>
</html>