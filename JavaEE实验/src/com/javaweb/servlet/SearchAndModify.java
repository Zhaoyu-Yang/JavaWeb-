package com.javaweb.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javaweb.javabean.UserInfo;
import com.javaweb.jdbc.UserInfoDAO;
public class SearchAndModify extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("modify");
        if(name!=null) //单击了‘修改用户’
        {
            String username=request.getParameter("modifyName");
            String password=request.getParameter("password");
            UserInfo user=new UserInfo();
            user.setUsername(username);
            user.setPassword(password);
            UserInfoDAO userDAO=new UserInfoDAO();
            try {
                userDAO.update(user);
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("修改失败："+e.getLocalizedMessage());
                out.print(goBack);
                return;
            }
        }
        out.print("修改成功！");
        out.print(goBack);
        out.close();
        response.sendRedirect("/JavaEE/SearchAndModify.jsp");
    }

}
