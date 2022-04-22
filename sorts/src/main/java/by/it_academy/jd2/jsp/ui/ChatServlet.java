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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        MessageService messageService = MessageService.getInstance();
        List<Message> message = messageService.getMessage(user);
        if (user == null){
            req.setAttribute("err", "who are you? please login");
        }else if (message == null){
            req.setAttribute("err", "You have no messages");
        }
        req.setAttribute("message", message);
        req.getRequestDispatcher("../jsp/chat.jsp").forward(req,resp);
    }
}
