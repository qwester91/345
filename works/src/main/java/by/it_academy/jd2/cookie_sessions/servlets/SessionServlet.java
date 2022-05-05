package by.it_academy.jd2.cookie_sessions.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        if (firstName != null && lastName != null){
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);

        }else if(session.getAttribute("firstName") == null &&
                session.getAttribute("lastName") == null) {
            writer.write("нэма значений");
            return;
        }
        writer.write("Привет " + (String) session.getAttribute("firstName") + " "
                + (String) session.getAttribute("lastName") + "!!");

    }
}
