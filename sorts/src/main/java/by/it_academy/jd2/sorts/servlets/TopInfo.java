package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.sorters.SortsInfo;
import by.it_academy.jd2.sorts.service.VoteInfo;

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
        Map<String, Long> mapResultsInfo =
                VoteInfo.resultInfo.getMapResultsInfo();;

        SortsInfo sorts = new SortsInfo();
        List<Map.Entry<String, Long>> entries = sorts.sortMap(mapResultsInfo);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Map.Entry<String, Long> entry : entries) {
            writer.write(entry.getKey());

        }
    }
}
