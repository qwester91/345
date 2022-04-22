package by.it_academy.jd2.jsp.ui;

import by.it_academy.jd2.jsp.api.core.dto.User;
import by.it_academy.jd2.jsp.statistics.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StatisticServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticsService statisticsService = StatisticsService.getInstance();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null || !"admin".equals(user.getRole())){
            req.setAttribute("err", "access denied");
        }
        int activeUser = statisticsService.getActiveUser();
        int countMessage = statisticsService.getCountMessage();
        int countUser = statisticsService.getCountUser();

        req.setAttribute("activeUser", activeUser);
        req.setAttribute("countMessage", countMessage);
        req.setAttribute("countUser", countUser);

        req.getRequestDispatcher("../jsp/statistics.jsp").forward(req, resp);
    }
}
