<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.library.pojo.DateTime"%>
<%@ page import="com.library.pojo.DateTime" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.library.utils.DruidUtil" %>
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

<link rel="stylesheet" id="templatecss" type="text/css"
	href="../public/css/message.css">
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DateTime date=new DateTime();
		//out.println(date.show());
		String time = date.show();
		
		String mes = request.getParameter("msg"); 
		
	try{
		String card = session.getAttribute("reader").toString(); 
		String sql = "insert into message values(null,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
		if (card!=null&&mes!=null&& !mes.trim().equals("")) {
			int i = queryRunner.update(sql,card,mes,time);
		if (i > 0) {
	%>
	<script>
		alert('留言成功！');
		window.location.href = "./15checkMessage.jsp";
	</script>
	<%
		}
		else {
			%>
	<script>
		alert('留言未成功！');
		window.location.href = "./13message.jsp";
	</script>
			<%
				}
			
		} else {
	%>
	<script>
		alert('留言未成功！留言不能为空！');
		window.location.href = "./13message.jsp";
	</script>
	<%
		}
	%>
	<%
		}catch(Exception e){
			%>
	<script>
		alert('留言未成功！请先登录！');
		window.location.href = "./06borrow.jsp";
	</script>
			<%
		}
	%>
</body>
</html>