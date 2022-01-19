<%@ page import="java.sql.*" %>
<%@ page import="com.library.pojo.DateTime" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.library.utils.DruidUtil" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanHandler" %>
<%@ page import="com.library.pojo.Borrow_booksBean" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.utils.CompareDate" %>
<%@ page import="com.library.pojo.Borrow_cardBean" %>
<%@ page import="com.library.pojo.RulesBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		QueryRunner queryRunner=new QueryRunner(DruidUtil.getDataSource());
		String book = request.getParameter("bookid");
		session.setAttribute("book", book);
		DateTime date = new DateTime();
		String now = date.show();
		String bookid = request.getParameter("bookid");
		
		String sql="select*from borrow_books where book_id = ?";

		List<Borrow_booksBean> judge = queryRunner.query(sql, new BeanListHandler<>(Borrow_booksBean.class), bookid);
		String end = "";
		String ret = "";
		String card = "";
		for (int i = 0; i < judge.size(); i++){
			end = judge.get(i).getEnd_date();
			ret = judge.get(i).getReturn_date();
			card = judge.get(i).getReturn_date();
		}
		if(ret==null){
		//CompareDate cd = new CompareDate();
		long n = CompareDate.show(now,end);
		//out.println(sql);
		//out.println(n);
		//out.println(end);
		//out.println(now);
		session.setAttribute("days", n);
		
		String sql1="select * from borrow_card where id = ?";

			List<Borrow_cardBean> rs1 = queryRunner.query(sql1, new BeanListHandler<>(Borrow_cardBean.class), card);
		String rule = "";
			for (int i = 0; i < rs1.size(); i++){
			rule = String.valueOf(rs1.get(i).getRule_id());
		}

		String sql2="select*from rules where id = ?";
		List<RulesBean> res2 = queryRunner.query(sql2, new BeanListHandler<>(RulesBean.class), rule);
		String fee = "";
			for (int i = 0; i < res2.size(); i++) {
			fee = String.valueOf(res2.get(i).getOvertime_fee());
		}
		session.setAttribute("fee", fee);
		%>
		<script>
			window.location.href = "04return.jsp";
		</script>
		<%
		}else{
			%>
			<script>
				alert("该书未借出或不存在！");
				window.location.href = "04judge.jsp";
			</script>
			<%
		}


%>
</body>
</html>