package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.sorters.Sorts;
import by.it_academy.jd2.sorts.service.VoteResultsStyles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TopStyles", urlPatterns = "/topStyles")
public class TopStyles extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, Integer> mapResultsStyles =
                VoteResultsStyles.resultsStyles.getMapResultsStyles();

        Sorts sorts = new Sorts();
        List<Map.Entry<String, Integer>> entries = sorts.sortMap(mapResultsStyles);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Map.Entry<String, Integer> entry : entries) {
            writer.write(entry.getKey() + " - " + entry.getValue() + "<br>");

        }
    }
}
