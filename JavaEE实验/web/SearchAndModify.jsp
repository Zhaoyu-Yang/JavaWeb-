<%--
  Created by IntelliJ IDEA.
  User: 20127
  Date: 2021/10/22
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.sql.*" errorPage="" %>
<%@page import="com.javaweb.javabean.UserInfo,com.javaweb.jdbc.UserInfoDAO"%>

<html>
<head>
    <title>查询和修改</title>
</head>
<%
    String username=request.getParameter("queryName");
    UserInfo user = new UserInfo();
    //if(queryName!=null){
        if(username!=null&&username!="")
        {
            com.javaweb.jdbc.UserInfoDAO userDAO=new com.javaweb.jdbc.UserInfoDAO();
            UserInfo temp=userDAO.searchByUsername(username);
            if(temp==null)
            {
                out.print("用户名不存在！");
            }
            else
                user=temp;//防止user为null，导致下文的user.getUsername()产生异常
        }
    //}
%>
<body>
<div align="center">
    <form name="query" method="post" action="">
        <font face="宋体" size="6"><strong>查询和修改用户</strong></font><br/><hr/><br/>
        输入查询的用户名：<input name="queryName" type="text"/>
        <input type="submit" name="query" value="查询用户" /><br/><br/><hr/><br/>
    </form>

    <form name="modify" method="post" action="searchAndModify">
        用户名：
        <input name="modifyName" type="text" value="<%=user.getUsername()%>" readonly="readonly" />
        <br/><br/>
        密&nbsp;&nbsp;码：
        <input name="password" type="text" value="<%=user.getPassword()%>"/>
        <br /><br />
        <input type="submit" name="modify" value="修改用户" />
    </form>
    <hr/>
    <a href="DeleteUser.jsp">删除用户</a><br/>
    <a href="AddUser.jsp">添加用户</a><br/>
</div>
</body>
</html>
