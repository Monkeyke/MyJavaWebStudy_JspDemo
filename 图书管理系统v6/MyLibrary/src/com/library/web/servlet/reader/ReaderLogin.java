package com.library.web.servlet.reader;

import com.alibaba.fastjson.JSON;
import com.library.pojo.ReaderBean;
import com.library.pojo.ResultBean;
import com.library.service.LoginReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/readerLogin")
public class ReaderLogin extends HttpServlet {
    private ResultBean result =new ResultBean(true);
    private LoginReaderService confirmService=new LoginReaderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String psw = request.getParameter("psw");
        String checkCode = request.getParameter("checkCode");
        //获取验证码

        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");

        //判断密码是否为空
        if (user == null || user.trim().equals("")) {
            result.setFlag(false);
            result.setErrorMsg("账号不能为空") ;
        } else if (psw == null || psw.trim().equals("")) {
            result.setFlag(false);
            result.setErrorMsg("密码不能为空") ;
        } else if (checkCode == null || checkCode.trim().equals("")) {
            result.setFlag(false);
            result.setErrorMsg("验证码不能为空") ;
        }else if(code.equals(checkCode)){
            try {
                ReaderBean readerBean = confirmService.findAResult(user, psw);
                session = request.getSession();
                session.setAttribute("reader", readerBean.getId());
                session.setAttribute("reader_first", "1"); // 登录
                result.setData(request.getContextPath()+"/reader/01main.jsp");
                result.setErrorMsg("登录成功");
            } catch (Exception e) {
                e.printStackTrace();
                result.setFlag(false);
                result.setErrorMsg("账号或者密码错误！");
            }
            }else{
                //验证码输入异常
                result.setFlag(false);
                result.setErrorMsg("验证码输入错误");
            }

        String string = JSON.toJSONString(result);
        response.getWriter().write(string);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}