<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 18751
  Date: 2022/11/12
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drogen</title>
</head>
<body>
<%
    java.util.List<Bean> drogenBeanList = (List<Bean>) session.getAttribute("drogenlist");
    session.setAttribute("Drogenlist",drogenBeanList);
    String contextPath = request.getContextPath();
%>
<form action="<%=contextPath%>/drogen" method="post">
    <table align="center">
        <tr>
            <td><input type="text" placeholder="请您输入四字成语" name="word"></td>
            <td><button type="submit">提交</button> </td>
        </tr>
    </table>
    <%=drogenBeanList.size()%>
</form>
<c:forEach items="${Drogenlist}" var="b">
    <table>
        <tr>
            <td>${b.idiom}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
