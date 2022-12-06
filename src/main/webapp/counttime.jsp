<%--
  Created by IntelliJ IDEA.
  User: 18751
  Date: 2022/11/15
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! Integer i;%>
<html>
<head>
    <title>Jishuqi</title>
</head>
<body>
<jsp:useBean id="pageScope" scope="page" class = "com.bean.CounterBean"/>
<jsp:useBean id="requestScope" scope="request" class="com.bean.CounterBean"/>
<jsp:useBean id="sessionScope" scope="session" class="com.bean.CounterBean"/>
<jsp:useBean id="applicationScope" scope="application" class="com.bean.CounterBean"/>

<%
    if (i==null){
        i=1;
    }else {
        i+=1;
    }
%>

共享变量：<%=i%><br>
使用page获取的数据为：<%=pageScope.getCount()+1%><br/>
使用session获取的数据为：<%=sessionScope.getCount()+1%><br/>
使用request获取的数据为：<%=requestScope.getCount()+1%><br>
使用qpplication获取的数据为：<%=applicationScope.getCount()+1%><br/>


</body>
</html>
