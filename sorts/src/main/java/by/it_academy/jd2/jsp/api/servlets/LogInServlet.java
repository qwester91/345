package by.it_academy.jd2.jsp.api.servlets;

import by.it_academy.jd2.jsp.api.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {
    private final String LOGIN_PARAM = "login";

    private final String PASSWORD_PARAM = "password";
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        UserService userService = UserService.getInstance();
        PrintWriter writer = resp.getWriter();
        String redirect = req.getContextPath() + "/ui?who=" + login;
        try {
          userService.logIn(login, password, req.getSession());
        } catch (IllegalAccessException e) {
           redirect = req.getContextPath() + "/ui/signIn?err=" + e.getMessage() ;
        }finally {
            resp.sendRedirect(redirect);
        }

    }
/**
 * для проверки логаута и подсчета пользователей
 */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.removeAttribute("user");
//    }
}
