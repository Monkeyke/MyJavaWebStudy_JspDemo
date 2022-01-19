package com.library.web.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.library.pojo.BookBean;
import com.library.pojo.Borrow_cardBean;
import com.library.pojo.ResultBean;
import com.library.service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/borrowbook")
public class BorrowSub extends HttpServlet {
    private BorrowService service=new BorrowService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ResultBean result=new ResultBean(true);
        String user = request.getParameter("userid");
        String book = request.getParameter("bookid");
        String date1 = request.getParameter("date1");

        try {
            //book
            BookBean bookid = service.findBookid(book);
            //借阅者
            Borrow_cardBean userByid = service.findUserByid(user);
            //rules
            if(userByid.getId()==null){
                result.setFlag(false);
                result.setErrorMsg("没有此账号！");
            }

            if(bookid.getId()==null){
                result.setFlag(false);
                result.setErrorMsg("没有此图书！");
            }

            if(userByid!=null&&bookid!=null){
                int i = service.insertBorrw_Book(date1, user, book);
                if(i>0){
                    result.setErrorMsg("插入成功");
                }

            }


        } catch (Exception e) {
            result.setFlag(false);
            result.setErrorMsg("ERROR！");
            e.printStackTrace();
        }

        String jsonString = JSON.toJSONString(result);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
