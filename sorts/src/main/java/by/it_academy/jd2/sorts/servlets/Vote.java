package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.dto.VoteInfo;
import by.it_academy.jd2.sorts.dto.VoteResultsMusicians;
import by.it_academy.jd2.sorts.dto.VoteResultsStyles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] musicians = req.getParameterValues("musician");
        String[] styles = req.getParameterValues("styles");
        String[] info = req.getParameterValues("info");

        Long timeMillis = System.currentTimeMillis();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        if(musicians.length != 1 || styles.length < 3 || styles.length > 5 || info.length != 1){
            writer.write("Error!! неверные данные");
        }
        writer.write("Данные приняты");
        VoteResultsStyles.isResultStyles();
        VoteResultsStyles.resultsStyles.addStyles(styles);

        VoteResultsMusicians.isResultMusicians();
        VoteResultsMusicians.result.addMusicians(musicians);

        VoteInfo.isResultInfo();
        VoteInfo.resultInfo.addInfo(info, timeMillis);

    }
}
