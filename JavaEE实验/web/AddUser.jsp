<%--
  Created by IntelliJ IDEA.
  User: 20127
  Date: 2021/10/22
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form method="post" action="addUserServlet">
    <div align="center"><font face="宋体" size="6"><strong>
        添加用户</strong></font><br/><hr/>
        用户名：<input name="username" type="text"/>
        <br/>
        <br/>
        密&nbsp;&nbsp;码：
        <input name="password" type="text"/>
        <br />
        <br />
        <input type="submit" value="添加" />
        <input type="reset"  value="取消" />
    </div>
</form>

</body>
</html>
