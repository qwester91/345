package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.dto.ListOfMusiciansDto;
import by.it_academy.jd2.sorts.service.dto.ListOfStylesDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name = "ListOfStyles" , urlPatterns = "/ListOfStyles")
public class ListOfStyles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        ListOfStylesDto service = ListOfStylesDto.getListOfStyles();
        List<String> styles = service.getStyles();
        int i = 1;
        for (String style : styles) {
            writer.write("<p>"+ i++ + " - " + style + "</p></br>" );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String style = req.getParameter("style");
        ListOfStylesDto service = ListOfStylesDto.getListOfStyles();
        service.addStyles(style);
    }
}
