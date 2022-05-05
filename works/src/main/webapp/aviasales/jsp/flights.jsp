<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 04.05.2022
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>flightsTable</title>


</head>
<body>
<h1>Параметры фильтрации интересны мне </h1>
<form action = <%=request.getContextPath() + "/flights"%> method = "POST">
departure time:      <input type = "date" name = "departureDate">
<br /><br />
arrival time:      <input type = "date" name = "arrivalDate">

<br /><br />
departure airport
<select name="departureAirport" >
    <option value="">аэропорт отправления</option>
    <c:forEach items="${airports}" var="airport">
        <option value ="${airport.getAirport_code()}">${airport.getAirport_code()}, ${airport.getAirport_name()}, ${airport.getCity()}</option>
    </c:forEach>

</select>
<br /><br />

arrival airport
<select name="arrivalAirport" >
    <option value="">аэропорт прилета</option>
    <c:forEach items="${airports}" var="airport">
        <option value="${airport.getAirport_code()}">${airport.getAirport_code()}, ${airport.getAirport_name()}, ${airport.getCity()}</option>
    </c:forEach>

</select>
<br /><br />

<input type = "submit" value = "select" />
</form>

</body>
</html>
