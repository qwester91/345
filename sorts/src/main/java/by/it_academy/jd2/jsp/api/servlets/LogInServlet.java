package by.it_academy.jd2.jsp.api.servlets;

import by.it_academy.jd2.jsp.api.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = UserService.getInstance();
        PrintWriter writer = resp.getWriter();
        try {
          userService.logIn(login, password, req.getSession());
        } catch (IllegalAccessException e) {
           writer.write( e.getMessage());
        }

    }
}
