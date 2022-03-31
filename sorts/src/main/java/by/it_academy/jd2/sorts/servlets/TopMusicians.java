package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.Sorts;
import by.it_academy.jd2.sorts.dto.VoteResultsMusicians;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TopMusicians", urlPatterns = "/topMusicians")
public class TopMusicians extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, Integer> mapResultsMusicians =
                VoteResultsMusicians.result.getMapResultsMusicians();

        Sorts sorts = new Sorts();
        List<Map.Entry<String, Integer>> entries = sorts.sortMap(mapResultsMusicians);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Map.Entry<String, Integer> entry : entries) {
            writer.write(entry.getKey() + " - " + entry.getValue() + "<br>");

        }
    }
}
