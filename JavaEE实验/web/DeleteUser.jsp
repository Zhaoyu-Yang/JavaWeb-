<%--
  Created by IntelliJ IDEA.
  User: 20127
  Date: 2021/10/22
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
</head>
<body>
<form  method="post" action="deleteUser">
    <div align="center"><font face="宋体" size="6"><strong>
        删除用户</strong></font><br/>
        <hr/>
        <p>
        </p>
        <p>输入删除的用户名:<input name="username" type="text"/><br/><br/>
            <input type="submit" name="delete" value="删除用户" />
            <br />
            <br />
        </p>
    </div>
</form>

</body>
</html>
