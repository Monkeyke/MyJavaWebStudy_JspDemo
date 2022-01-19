<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanHandler" %>
<%@ page import="com.library.pojo.RulesBean" %>
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
<style>
	body{
		background-color:#fff;
		color:black;
	}
</style>
</head>
<body>
<script>
$(function () { 
	$("[data-toggle='popover']").popover();
});
</script>
<jsp:useBean id="msg" scope="session" class="com.library.utils.DruidUtil"></jsp:useBean>
<div align="center"><h1 style="color:steelblue;font-family:YouYuan;font-weight:900;">读者规则信息查看</h1></div>
<div style="margin-top:5%;" align="center">

<%		
		String sql = "select * from rules";
		QueryRunner qr = new QueryRunner(msg.getDataSource());
		List<RulesBean> list = qr.query(sql, new BeanListHandler<>(RulesBean.class));

		for (int i =0;i<list.size();i++) {

		if(list.get(i).getId() % 2== 1){
%>

	<button type="button" class="btn btn-lg btn-info" title="可借阅数量：<%=list.get(i).getBorrow_num() %>"   data-html="true"
			data-container="body" data-trigger="focus" data-toggle="popover" data-placement="left" 
			data-content="可借阅天数：<%=list.get(i).getLimit_day() %><br>可借阅图书馆：<%=list.get(i).getBorrow_library() %><br>过期扣费/天：<%=list.get(i).getOvertime_fee() %>" style="width:40%;height:100%;font-size:17px;margin-top:4%;">
			
			借阅证规则编号：<%=list.get(i).getId()%>
		
	</button><br><br>
<%
		}else{
			%>
			<button type="button" class="btn btn-lg  btn-primary" title="可借阅数量：<%=list.get(i).getBorrow_num() %>"   data-html="true"
					data-container="body" data-trigger="focus" data-toggle="popover" data-placement="right" 
					data-content="可借阅天数：<%=list.get(i).getLimit_day() %><br>可借阅图书馆：<%=list.get(i).getBorrow_library() %><br>过期扣费/天：<%=list.get(i).getOvertime_fee() %>" style="width:40%;height:100%;font-size:17px;margin-top:4%;">
					
			借阅证规则编号：<%=list.get(i).getId()%>

			</button><br><br>
<%
		}
		}
 %>
 </div>
</body>
</html>