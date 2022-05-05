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

<h1>Возможные рейсы</h1>
<table>
    <tr >
        <th> Flight_id</th>
        <th> Flight_no</th>
        <th> Scheduled_departure</th>
        <th> Scheduled_arrival</th>
        <th> Departure_airport</th>
        <th> Arrival_airport</th>
        <th> Status</th>
        <th> Aircraft_code</th>
        <th> Actual_departure</th>
        <th> Actual_arrival</th>

    </tr>

    <c:forEach var="list" items="${flightList}" >
        <tr><td> ${list.getFlight_id()}</td>
            <td> ${list.getFlight_no()}</td>
            <td> ${list.getScheduled_departure()}</td>
            <td> ${list.getScheduled_arrival()}</td>
            <td> ${list.getDeparture_airport()}</td>
            <td> ${list.getArrival_airport()}</td>
            <td> ${list.getStatus()}</td>
            <td> ${list.getAircraft_code()}</td>
            <td> ${list.getActual_departure()}</td>
            <td> ${list.getActual_arrival()}</td>

        </tr>
    </c:forEach>
</table>
<c:if test="${page>1}">

    <form action=<%=request.getContextPath() +
            "/flights?departureDate=" + request.getParameter("departureDate") +
            "&departureAirport=" + request.getParameter("departureAirport") +
            "&arrivalDate=" + request.getParameter("arrivalDate") +
            "&arrivalAirport=" + request.getParameter("arrivalAirport") +
            "&page="%>${page-1} method="POST">
        <p><input type="submit" value="previos"></p>
    </form>
</c:if>
<c:if test="${countpages>page}">

        <form action=<%=request.getContextPath() +
            "/flights?departureDate=" + request.getParameter("departureDate") +
            "&departureAirport=" + request.getParameter("departureAirport") +
            "&arrivalDate=" + request.getParameter("arrivalDate") +
            "&arrivalAirport=" + request.getParameter("arrivalAirport") +
            "&page="%>${page+1} method="POST">
            <p><input type="submit" value="next"></p>
        </form>
</c:if>

</body>
</html>
