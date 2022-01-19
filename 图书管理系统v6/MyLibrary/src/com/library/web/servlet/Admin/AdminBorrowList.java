package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Borrow_booksBean;
import com.library.pojo.Vo;
import com.library.service.BorrowList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/borrowList")
public class AdminBorrowList extends HttpServlet {
    private BorrowList borrowList=new BorrowList();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Vo vo = new Vo();
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");
        String condition = (String) request.getParameter("condition");
        String conditionValue = (String) request.getParameter("conditionValue");

        if(page == null) {
            page = "1";
        }
        if(limit == null) {
            limit = "10";
        }
        try {
            List<Borrow_booksBean> borrow_booksBeans = borrowList.showBorrowList(page, limit, condition, conditionValue);
            int countBorrows = Math.toIntExact(borrowList.findCountBorrows());
            vo.setData(borrow_booksBeans);
            vo.setCount(countBorrows);
            vo.setCode(0);
            vo.setMsg("SuCCESS");
        } catch (Exception e) {
            vo.setCode(1);
            vo.setMsg("error");
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}