package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Book_SortBean;
import com.library.pojo.Vo;
import com.library.service.AdminBookListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/sortList")
public class AdminSortList extends HttpServlet {
    private AdminBookListService  admin=new AdminBookListService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Vo vo = new Vo();
        try {
            List<Book_SortBean> book_sortBeans = admin.showSortList();
            vo.setMsg("SUCCEs");
            vo.setData(book_sortBeans);
            vo.setCode(0);

        } catch (Exception e) {
            vo.setMsg("ERROR");
            vo.setCode(1);
            e.printStackTrace();
        }

        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}