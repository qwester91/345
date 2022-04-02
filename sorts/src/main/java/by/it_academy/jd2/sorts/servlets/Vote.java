package by.it_academy.jd2.sorts.servlets;

import by.it_academy.jd2.sorts.service.VoteService;
import by.it_academy.jd2.sorts.service.dto.VoteDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int musicians = Integer.parseInt(req.getParameter("musician")) - 1;
        int[] styles = Arrays.stream(req.getParameterMap().get("style"))
                .mapToInt(s -> Integer.parseInt(s) - 1)
                .toArray();
        String info = req.getParameter("info");

        Long time = System.currentTimeMillis();

        VoteDto vote = new VoteDto(musicians, styles, info, time);
        VoteService voteService = VoteService.getVoteService();
        voteService.save(vote);


    }
}
