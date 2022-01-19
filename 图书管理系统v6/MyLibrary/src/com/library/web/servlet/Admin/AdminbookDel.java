package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Vo;
import com.library.service.AdminDelBooks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/bookDel")
public class AdminbookDel extends HttpServlet {
    private AdminDelBooks admin=new AdminDelBooks();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Vo vo = new Vo();
        String id = request.getParameter("id");
        try {
            int i = admin.delBooksById(id);
            if(i>0){
                vo.setCode(0);
                vo.setMsg("删除成功");
            }

        } catch (Exception e) {
            vo.setCode(1);
            vo.setMsg("删除失败");
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}