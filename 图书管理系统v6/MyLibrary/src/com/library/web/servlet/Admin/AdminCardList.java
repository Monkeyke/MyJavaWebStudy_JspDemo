package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Borrow_cardBean;
import com.library.pojo.Vo;
import com.library.service.AdminSortListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/cardList")
public class AdminCardList extends HttpServlet {
    private AdminSortListService admin=new AdminSortListService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Vo vo = new Vo();
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");
        String condition = (String) request.getParameter("condition");
        String conditionValue = (String) request.getParameter("conditionValue");
        try {
            List<Borrow_cardBean> borrow_cardBeans = admin.showAllCard(limit, page, condition, conditionValue);
            System.out.println(borrow_cardBeans.toString());
            vo.setCode(0);
            vo.setData(borrow_cardBeans);
            //获取count
            int cardCount = Math.toIntExact(admin.findCardCount());
            vo.setCount(cardCount);
            vo.setMsg("success");


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