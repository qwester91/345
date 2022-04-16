package by.it_academy.jd2.jsp.api.servlets;

import by.it_academy.jd2.jsp.api.core.dto.User;
import by.it_academy.jd2.jsp.api.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "RegistrationServlet" , urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        LocalDate date = LocalDate.parse(dateOfBirth);

        User user = new User(login, password, name, date);
        PrintWriter writer = resp.getWriter();

        UserService userService = UserService.getInstance();
        try {
            userService.register(user);
        } catch (IllegalAccessException e) {
           writer.write( e.getMessage());
        }


    }
}
