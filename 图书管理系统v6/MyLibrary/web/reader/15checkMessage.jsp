<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%--<%@ page import="javabean.DateTime"%>--%>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.library.utils.DruidUtil" %>
<%@ page import="com.library.pojo.MessageBean" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<link rel="stylesheet" id="templatecss" type="text/css" href="../public/css/message.css">
<style type="text/css">
	.text-dark{
		color:black;
		font-family:YouYuan;
	}
	body{
		background-color:#fff;
		font-size:16px;
	}
</style>
</head>
<body>
	<div align="center"><h3 style="color:#F08080;">☆★留言板★☆</h3></div>
<%		
		String sql = "select CARD_ID,DETAIL,PUBLIC_DATE from message order by PUBLIC_DATE desc";
		QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
		List<MessageBean> list = queryRunner.query(sql, new BeanListHandler<>(MessageBean.class));

	for (int i = 0; i < list.size(); i++){
	%>
	<div class="panel panel-default" style="width:60%;height:80%; margin-left:20%;">
	  	<div class="panel-body" align="center">
			<p class="bg-info text-dark"><%=list.get(i).getCard_id()%></p>
			<div style="word-wrap:break-word;"><p class="bg-warning text-dark"><%=list.get(i).getDetail()%></p></div>
			<p class="bg-danger text-dark"><%=list.get(i).getPublic_date()%></p>
		</div>
	</div>
<hr>
<%
		}
 %>
</body>
</html>