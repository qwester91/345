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

@WebServlet (name = "ListOfMusician" , urlPatterns = "/ListOfMusician")
public class ListOfMusician extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        ListOfMusiciansDto service = ListOfMusiciansDto.getListOfMusicians();
        List<String> musiciants = service.getMusiciants();
        int i = 1;
        for (String musiciant : musiciants) {
            writer.write("<p>"+ i++ + " - " + musiciant + "</p></br>" );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String musiciant = req.getParameter("musiciant");
        ListOfMusiciansDto service = ListOfMusiciansDto.getListOfMusicians();
        service.addMusiciants(musiciant);
    }
}
