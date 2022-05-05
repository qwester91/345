<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Статистика!!!</h1>
 <c:if test="${err==null}">
     <p>количество зарегистрированных юзеров :${countUser}</p><br>
     <p>количество активных юзеров :${activeUser}</p><br>
     <p>количество отправленных сообщений :${countMessage}</p><br>

 </c:if>
<c:if test="${err!= null}">
    ${err}
</c:if>
</body>
</html>
