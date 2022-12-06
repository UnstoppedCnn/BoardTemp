<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Board" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 18751
  Date: 2022/11/11
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
    <style>
        .msg{
            width: 1800px;
        }
    </style>
</head>
<body>
<%
    List<Board> boardlist = (List<Board>) session.getAttribute("boards");
    session.setAttribute("boards",boardlist);
%>
<form action="<%=request.getContextPath()%>/addtoboard" method="post">
    <table border="2" align="center">
        <tr>
            <td>作者</td>
            <td><input type="text" placeholder="请输入您的昵称" name="anthor"></td>
        </tr>
        <tr>
            <td>标题</td>
            <td><input type="text" placeholder="请输入需要添加的标题" name="title"></td>
        </tr>
        <tr>
            <td>内容</td>
            <td><textarea rows="5" cols="250" name="content"></textarea></td>
        </tr>
        <tr >
            <td align="center"><button type="submit">提交</button></td>
        </tr>
    </table>
</form>
<c:forEach items="${boards}" var="b">
    <table  align="center" border="2px">
        <tr>
            <td class="msg">
                <p align="center">${b.title}<br>
                ${b.board}<br></p>
                <p align="right" >${b.anthor}<br></p>
            </td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
