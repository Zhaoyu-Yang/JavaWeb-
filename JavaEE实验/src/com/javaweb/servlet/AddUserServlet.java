package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.javaweb.javabean.UserInfo;
import com.javaweb.jdbc.UserInfoDAO;

public class AddUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();

        String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
        if(username==null||username.equals(""))
        {
            out.print("用户名不能为空！");
            out.print(goBack);
        }
        String password=request.getParameter("password");
        UserInfo user=new UserInfo();
        user.setUsername(username);
        user.setPassword(password);//注入属性

        UserInfoDAO userDAO=new UserInfoDAO();
        if(userDAO.exists(user.getUsername()))
        {
            out.print("用户名已存在！");
            out.print(goBack);
            return;
        }
        try {
            userDAO.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("添加失败:"+e.getLocalizedMessage());
            out.print(goBack);
            return;
        }
        out.print("添加成功！");
        out.print(goBack);
        out.close();
    }

}