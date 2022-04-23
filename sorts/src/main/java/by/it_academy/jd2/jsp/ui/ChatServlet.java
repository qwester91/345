package by.it_academy.jd2.jsp.ui;

import by.it_academy.jd2.jsp.api.core.dto.Message;
import by.it_academy.jd2.jsp.api.core.dto.User;
import by.it_academy.jd2.jsp.api.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatServlet extends HttpServlet {

    private final String SESSION_ATRIBUTE = "user";

    private final String ERROR_ATRIBUTE = "err";
    private final String MESSAGE_ATRIBUTE = "message";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(SESSION_ATRIBUTE);


        MessageService messageService = MessageService.getInstance();
        List<Message> message = messageService.getMessage(user);
        if (user == null){
            req.setAttribute(ERROR_ATRIBUTE, "who are you? please login");
        }else if (message == null){
            req.setAttribute(ERROR_ATRIBUTE, "You have no messages");
        }
        req.setAttribute(MESSAGE_ATRIBUTE, message);
        req.getRequestDispatcher("../jsp/chat.jsp").forward(req,resp);
    }
}
