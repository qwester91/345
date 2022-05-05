package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.sorters.SortsInfo;
import by.it_academy.jd2.sorts.service.InfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TopInfo", urlPatterns = "/topInfo")
public class TopInfo extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        InfoService infoService = new InfoService();
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        for (String info : infoService.getInfo()) {
            writer.write("<p>" + info + "</p></br>");

        }
    }
}
