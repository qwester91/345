package by.it_academy.jd2.cookie_sessions.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PrintWriter writer = resp.getWriter();

        if (firstName != null && lastName != null){
            Cookie firstName1 = new Cookie("firstName", firstName);
            Cookie lastName1 = new Cookie("lastName", lastName);
            resp.addCookie(firstName1);
            resp.addCookie(lastName1);

        }else if(req.getCookies() != null) {
            for (Cookie cookie : req.getCookies())
               if( cookie.getName().equals("firstName")){
                   firstName = cookie.getValue();
               }else if(cookie.getName().equals("lastName")){
                   lastName = cookie.getValue();
               }
        }else if (firstName == null && lastName == null){
            writer.write("нэма значений");
            return;
        }
        writer.write("Привет " + firstName + " " + lastName + "!!");

    }
}
