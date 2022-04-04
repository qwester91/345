package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.TopService;
import by.it_academy.jd2.sorts.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TopMusicians", urlPatterns = "/topMusicians")
public class TopMusicians extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        TopService topMusiciansService = new TopService();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (String topMusician : topMusiciansService.getTop(VoteService.getVoteService().getMusicantsVote())) {
            writer.write("<p>" + topMusician + "</p></br>" );
        }
    }
}
