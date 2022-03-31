package by.it_academy.jd2.sorts.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "ListOfStyles" , urlPatterns = "/ListOfStyles")
public class ListOfStyles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("1 - фолк<br>2 - кантри<br>3 - блюз<br>4 - RnB<br>" +
                "5 - джаз<br>6 - шансон<br>7 - электронщина<br>8 - рок<br>9 - хип-хоп<br>10 - поп");

    }
}
