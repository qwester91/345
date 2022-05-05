<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
        pageEncoding="UTF-8"
%>
<%@page import="by.it_academy.jd2.jsp.api.core.dto.Message"%>
<%@page import=" by.it_academy.jd2.jsp.api.core.dto.User"%>
<%@page import=" by.it_academy.jd2.jsp.api.service.MessageService" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose >
    <c:when test="${err!=null}">
        ${err}
    </c:when>
    <c:otherwise>
        ваши сообщения: </br>
        <c:forEach var="messages" items="${message}">
              <p> from: ${messages.getFrom()} ,
            ${messages.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}</p>
            <p> ${messages.getTextMessage()}</p></br></br>
        </c:forEach>

    </c:otherwise>
</c:choose>
</body>
</html>
