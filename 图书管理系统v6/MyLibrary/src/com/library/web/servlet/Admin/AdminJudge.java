package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Borrow_cardBean;
import com.library.pojo.ResultBean;
import com.library.service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminjudge")
public class AdminJudge extends HttpServlet {
    private BorrowService service=new BorrowService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ResultBean result=new ResultBean(true);
        String bookid = request.getParameter("bookid");
        String userid = request.getParameter("userid");

        try {
            Borrow_cardBean borrow_cardBean = service.returnBook(bookid, userid);
            if(borrow_cardBean!=null){
                service.removeMark(bookid,userid);
            }else{
                result.setFlag(false);
                result.setErrorMsg("删除失败");
            }


        } catch (Exception e) {
            result.setFlag(false);
            result.setErrorMsg("ERROR");
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(result);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
