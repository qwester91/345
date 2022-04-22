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
    private final String LOGIN_PARAM = "login";
    private final String PASSWORD_PARAM = "password";
    private final String NAME_PARAM = "name";
    private final String DATE_OF_BIRTH_PARAM = "dateOfBirth";


    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String name = req.getParameter(NAME_PARAM);
        String dateOfBirth = req.getParameter(DATE_OF_BIRTH_PARAM);
        LocalDate date = LocalDate.parse(dateOfBirth);
        String redirect = req.getContextPath() + "/ui?reg=registration complete";

        User user = new User(login, password, name, date);
        PrintWriter writer = resp.getWriter();

        UserService userService = UserService.getInstance();
        try {
            userService.register(user);
        } catch (IllegalAccessException e) {
           redirect = req.getContextPath() + "/ui/signUp?err=" + e.getMessage();
           writer.write( e.getMessage());
        } finally {
            resp.sendRedirect(redirect);
        }
    }
}
