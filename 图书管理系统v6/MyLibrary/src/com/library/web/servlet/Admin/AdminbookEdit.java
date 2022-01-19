package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.BookBean;
import com.library.pojo.Vo;
import com.library.service.AdminEditService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/bookEdit")
public class AdminbookEdit extends HttpServlet {
    private AdminEditService admin=new AdminEditService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BookBean bookbean = new BookBean();
        Vo vo = new Vo();
        bookbean.setId(Integer.parseInt(request.getParameter("id")));
        bookbean.setName(request.getParameter("name"));
        bookbean.setAuthor(request.getParameter("author"));
        bookbean.setLibrary_id(Integer.valueOf(request.getParameter("library_id")));
        bookbean.setSort_id(Integer.valueOf(request.getParameter("sort_id")));
        bookbean.setPosition(request.getParameter("position"));
        bookbean.setStatus(Integer.valueOf(request.getParameter("status")));
        bookbean.setDescription(request.getParameter("description"));

        try {
            int editbooks = admin.editbooks(bookbean);
            if(editbooks>0){
                vo.setCode(0);
                vo.setMsg("SUCCESS");
            }
        } catch (Exception e) {
            vo.setCode(1);
            vo.setMsg("ERROR");
            e.printStackTrace();
        }

        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}