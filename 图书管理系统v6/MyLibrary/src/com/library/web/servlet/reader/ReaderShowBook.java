package com.library.web.servlet.reader;

import com.alibaba.fastjson.JSON;
import com.library.pojo.BookBean;
import com.library.pojo.ResultBean;
import com.library.pojo.Vo;
import com.library.service.ReaderShowBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/book")
public class ReaderShowBook extends HttpServlet {
    private ReaderShowBookService readerShowBookService = new ReaderShowBookService();
    private Vo vo=new Vo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf8");
        request.setCharacterEncoding("UTF-8");
        // 接收参数
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");

        String condition = (String) request.getParameter("condition");//条件1

        String conditionValue = (String) request.getParameter("conditionValue");  //条件2

//        System.out.println(condition+"&&&"+conditionValue);

        String where = ""; // 无限制条件
        if (page == null) {
            page = "1";
        }
        if (limit == null) {
            limit = "5";
        }
        int limit1=Integer.parseInt(limit);
        int page1=Integer.parseInt(page);
        try {
            List<BookBean> bookBeans = readerShowBookService.readFindBook(limit1, page1,condition,conditionValue);
            int count = Math.toIntExact(readerShowBookService.findBookCount());
            vo.setCode(0);
            vo.setMsg("查询成功");
            vo.setCount(count);
            vo.setData(bookBeans);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonString = JSON.toJSONString(vo);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
