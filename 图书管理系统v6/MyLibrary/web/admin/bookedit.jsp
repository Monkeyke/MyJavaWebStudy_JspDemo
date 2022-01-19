<%@page import="java.sql.ResultSet"%>
<%@ page import="com.library.dao.AdminBookListDao" %>
<%@ page import="com.library.pojo.BookBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.LibraryBean" %>
<%@ page import="com.library.pojo.Book_SortBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>bookedit</title>
  <!-- layui -->
  <link rel="stylesheet" href="../public/layui/css/layui.css">
  <script src="../public/layui/layui.js"></script>
 
  <style>
    .layui-form{
      margin: 10px 20px;
    }
  </style>
</head>
<body>
  
  <%
      int id = Integer.parseInt(request.getParameter("id"));
      AdminBookListDao bookDao=new AdminBookListDao();


      BookBean bookList = bookDao.findById(id);
      String name = bookList.getName();
      String author = bookList.getAuthor();
      int library_id = bookList.getLibrary_id();
      int sort_id = bookList.getSort_id();
      String position = bookList.getPosition();
      int status = bookList.getStatus();
      String description = bookList.getDescription();

      // 获取图书馆列表
      List<LibraryBean> libraryList = bookDao.findAlLibrary();


      // 获取书籍分类
      List<Book_SortBean> book_sortList = bookDao.findAlbook_sort();

  %>
  
  <form class="layui-form   layui-form-pane" action="">
 <%-- 隐藏id --%>
  <input type="id" name="id" value=<%=id %> class="layui-hide">
  <!-- 书名 -->
  <div class="layui-form-item">
    <label class="layui-form-label">书名</label>
    <div class="layui-input-block">
      <input type="text" name="name" value=<%=name %> required  lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <!-- 作者 -->
  <div class="layui-form-item">
    <label class="layui-form-label">作者</label>
    <div class="layui-input-block">
      <input type="text" name="author" value=<%=author %> required  lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
    </div>
  </div>
  <!-- 图书馆 -->
  <div class="layui-form-item">
    <label class="layui-form-label">图书馆</label>
    <div class="layui-input-block">
      <select name="library_id" lay-verify="required">
      	<option value=""></option>
      	<%for(int i=0;i<libraryList.size();i++){ %>
      		<%-- 选中原来的 图书馆--%>
        	<option value=<%=libraryList.get(i).getId() %> <%if(Integer.parseInt(String.valueOf(libraryList.get(i).getId())) == library_id){ out.print("selected"); } %> ><%=libraryList.get(i).getName() %></option>
        <%} %>
      </select>
    </div>
  </div>
  <!-- 分类 -->
  <div class="layui-form-item">
    <label class="layui-form-label">分类</label>
    <div class="layui-input-block">
      <select name="sort_id" lay-verify="required">
      <option value=""></option>
        <% for(int i=0;i<book_sortList.size();i++){ %>
        <option value=<%=book_sortList.get(i).getId() %> <% if(book_sortList.get(i).getId() == sort_id) out.print("selected"); %>><%=book_sortList.get(i).getName() %></option>
        <%} %>
      </select>
    </div>
  </div>
  <!-- 位置 -->
  <div class="layui-form-item">
    <label class="layui-form-label">位置</label>
    <div class="layui-input-block">
      <input type="text" name="position" value=<%=position %> required  lay-verify="required" placeholder="请输入位置编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  <!-- 位置 -->
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <input type="radio" name="status" value="1" title="可借" <%if(status==1) out.print("checked"); %>>
      <input type="radio" name="status" value="0" title="不可借" <%if(status==0) out.print("checked"); %> >
    </div>
  </div>
   
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">书籍简介</label>
    <div class="layui-input-block">
      <textarea class="layui-textarea"  name="description" lay-verify="content" id="LAY_demo_editor"><%=description %></textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script>

layui.use(['form', 'layedit', 'jquery'], function(){
  //layer.closeAll();
  $ = layui.jquery;
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit;
  //监听提交
  form.on('submit(formDemo)', function(data){
    $.ajax({
    	url: './bookEdit',
    	method: 'post',
    	data: data.field, //JSON.stringify(data.field),
    	dataType: 'json',
    	success: function(data){
    		if(data.code == "0"){
    			parent.layer.msg("修改成功",{
    				icon: 6,
    				time: 500
    			});
    			setTimeout(function(){
    				var index = parent.layer.getFrameIndex(window.name); //操作父页面
            		parent.layer.close(index);
    			}, 500);
        		
    		}else{
    			leyer.msg("修改失败");
    		}
    	    
    	}
    })
    
    
    return false;
  });
});

</script>

</body>
</html>