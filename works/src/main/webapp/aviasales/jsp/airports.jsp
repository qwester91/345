<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<%@page import="by.it_academy.jd2.aviasales.dao.airport.Airport"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/aviasales/css/airport.css"/>
    <title>Aviasales</title>
</head>
<body>

<h1>Аэропорты</h1>
<table>
    <tr >
        <th> Код аэропорта</th>
        <th> Название аэропорта</th>
        <th> Город</th>
        <th> Координаты</th>
        <th> Часовой пояс</th>

    </tr>

<c:forEach var="airports" items="${airports}">
    <tr><td> ${airports.getAirport_code()}</td>
        <td> ${airports.getAirport_name()}</td>
        <td> ${airports.getCity()}</td>
        <td> ${airports.getCoordinates()}</td>
        <td> ${airports.getTimezone()}</td>

    </tr>

</c:forEach>
</table>

</body>
</html>
