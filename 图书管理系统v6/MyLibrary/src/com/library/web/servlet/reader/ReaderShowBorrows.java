package com.library.web.servlet.reader;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Borrow_booksBean;
import com.library.pojo.Vo;
import com.library.service.ReaderShowBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/reader/borrow")
public class ReaderShowBorrows extends HttpServlet {
    private ReaderShowBookService readerShowBookService = new ReaderShowBookService();
    private Vo vo=new Vo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf8");
        request.setCharacterEncoding("UTF-8");
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");
        String condition = (String) request.getParameter("condition");
        String conditionValue = (String) request.getParameter("conditionValue");
        if (page == null) {
            page = "1";
        }
        if (limit == null) {
            limit = "10";
        }
        HttpSession session = request.getSession();
        int limit1=Integer.parseInt(limit);
        int page1=Integer.parseInt(page);
        String  id = String.valueOf(session.getAttribute("reader"));
        try {
            List<Borrow_booksBean> borrow_booksBeans = readerShowBookService.readFindBorrows(limit1, page1, condition, conditionValue, id);
            int count = Math.toIntExact(readerShowBookService.FindBorrowsCount(id));
            System.out.println(borrow_booksBeans+"######"+count);
            vo.setCount(count);
            vo.setCode(0);
            vo.setData(borrow_booksBeans);
            vo.setMsg("成功");
            String jsonString = JSON.toJSONString(vo);
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
