package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.AdminBean;
import com.library.pojo.ResultBean;
import com.library.service.LoginAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
    private LoginAdminService loginservice=new LoginAdminService();
    private ResultBean result =new ResultBean(true);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        HttpSession session = request.getSession();
        try {
            AdminBean adminResult = loginservice.findAdminResult(username, password);
            result.setData(request.getContextPath() +"/admin/index.jsp");

            System.out.println(adminResult.getUsername());

        } catch (Exception e) {
            result.setFlag(false);
            result.setErrorMsg("账号或者密码错误！");
            e.printStackTrace();
        }

        String jsonString = JSON.toJSONString(result);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}