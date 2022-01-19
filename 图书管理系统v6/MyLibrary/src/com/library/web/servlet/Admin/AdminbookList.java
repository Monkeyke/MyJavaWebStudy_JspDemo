package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.BookBean;
import com.library.pojo.Vo;
import com.library.service.AdminBookListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/bookList")
public class AdminbookList extends HttpServlet {
    private AdminBookListService admin =new AdminBookListService();
    private Vo vo=new Vo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf8");
        request.setCharacterEncoding("UTF-8");
        String page = (String) request.getParameter("page");
        String limit = (String) request.getParameter("limit");
        String condition = (String) request.getParameter("condition");
        String conditionValue = (String) request.getParameter("conditionValue");
        if(page == null) {
            page = "1";
        }
        if(limit == null) {
            limit = "10";
        }
        if(condition == null || conditionValue == null || condition.isEmpty() || conditionValue.isEmpty()) {
            condition = null;
            conditionValue = null;
        }

        try {
                List<BookBean> bookBeans = admin.showBookList(page, limit, condition, conditionValue);
//                System.out.println(bookBeans.toString());
                 vo.setCode(0);
                 vo.setMsg("SUCCESS");
                 vo.setCount(26);
                 vo.setData(bookBeans);

            } catch (Exception e) {
                e.printStackTrace();
                  vo.setCode(1);
                  vo.setMsg("ERROR");

            }
        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}