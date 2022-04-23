package by.it_academy.jd2.jsp.ui;

import by.it_academy.jd2.jsp.api.core.dto.Roles;
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
    private final String SESSION_ATTRIBUTE = "user";

    private final String ERROR_ATTRIBUTE = "err";
    private final String ACTIVE_USER_ATTRIBUTE = "activeUser";
    private final String COUNT_MESSAGE_ATTRIBUTE = "countMessage";
    private final String COUNT_USER_ATTRIBUTE = "countUser";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticsService statisticsService = StatisticsService.getInstance();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(SESSION_ATTRIBUTE);
        if(user==null || !Roles.ADMIN.equals(user.getRole())){
            req.setAttribute(ERROR_ATTRIBUTE, "access denied");
        }
        int activeUser = statisticsService.getActiveUser();
        int countMessage = statisticsService.getCountMessage();
        int countUser = statisticsService.getCountUser();

        req.setAttribute(ACTIVE_USER_ATTRIBUTE, activeUser);
        req.setAttribute(COUNT_MESSAGE_ATTRIBUTE, countMessage);
        req.setAttribute(COUNT_USER_ATTRIBUTE, countUser);

        req.getRequestDispatcher("../jsp/statistics.jsp").forward(req, resp);
    }
}
