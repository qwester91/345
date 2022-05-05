package by.it_academy.jd2.jsp.statistics.servlets;

import by.it_academy.jd2.jsp.statistics.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        StatisticsService statisticsService = StatisticsService.getInstance();
        int activeUser = statisticsService.getActiveUser();
        int countMessage = statisticsService.getCountMessage();
        int countUser = statisticsService.getCountUser();

        writer.write("<p>Количество активных юзеров - </p>" + activeUser + "</br>");
        writer.write("<p>Количество сообщений - </p>" + countMessage + "</br>");
        writer.write("<p>Количество юзеров в системе - </p>" + countUser + "</br>");
    }
}
