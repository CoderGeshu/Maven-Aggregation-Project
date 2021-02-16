<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/12/22
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="/user/addUser" method="post">
        <label>
            姓名：<input type="text" name="name">
        </label>
        <label>
            性别：
            <select name="gender">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </label>
        <label>
            出生日期:<input name="birth" type="date">
        </label>
        <input type="submit" name="确定">
    </form>
</body>
</html>
