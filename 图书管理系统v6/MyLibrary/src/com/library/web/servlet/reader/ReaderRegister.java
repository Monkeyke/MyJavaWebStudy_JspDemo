package com.library.web.servlet.reader;

import com.alibaba.fastjson.JSON;
import com.library.pojo.ResultBean;
import com.library.service.RegisterReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/readerRegister")
public class ReaderRegister extends HttpServlet {
    private RegisterReaderService registerReaderService = new RegisterReaderService();
    private ResultBean resultBean=new ResultBean(true);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取参数信息
        String username = request.getParameter("user");
        String psw = request.getParameter("psw");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();

        if(checkCode.equals(session.getAttribute("code"))){
            try {
                registerReaderService.registerReader(username,psw);
                resultBean.setData("./reader/01main.jsp");
            } catch (Exception e) {
                resultBean.setFlag(false);
                resultBean.setErrorMsg("服务器异常！");
                e.printStackTrace();
            }
        }else{
            resultBean.setFlag(false);
            resultBean.setErrorMsg("验证码输入错误！");
        }

        String jsonString = JSON.toJSONString(resultBean);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}