package by.it_academy.jd2.cookie_sessions.servlets;

import by.it_academy.jd2.cookie_sessions.service.PersonService;
import by.it_academy.jd2.cookie_sessions.service.PersonServiceCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PrintWriter writer = resp.getWriter();
        int age = Integer.parseInt(req.getParameter("age"));

        String saveAs = req.getHeader("saveAs");

        if (firstName != null && lastName != null && saveAs != null) {
            PersonService.save(firstName, lastName, age, resp, req, saveAs);
        } else{
            writer.write("введены некорректные данные, сохранение невозможно");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String saveAs = req.getHeader("saveAs");


                try {
                    writer.write(PersonService.load(req,saveAs).toString());
                } catch (ClassNotFoundException e) {
                    writer.write("чтото пошло не так" + e);
                }


    }
}
