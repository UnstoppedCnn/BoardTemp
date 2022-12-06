<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<a href="<%=request.getContextPath()%>/queryall">留言板</a><br>
<a href="<%=request.getContextPath()%>/drogen.jsp">成语接龙</a>
</body>
</html>