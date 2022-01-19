package com.library.web.servlet.other;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkcode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //目标:创建出一张验证码图片，并且将图片输出到浏览器
        ValidateCode validateCode = new ValidateCode(150, 60, 4, 30);
        //获取验证码图片上的字
        String code = validateCode.getCode();
        //将服务器创建的验证码，存储到session中
        request.getSession().setAttribute("code",code);

        //将验证码图片输出到浏览器
        validateCode.write(response.getOutputStream());
    }
}
