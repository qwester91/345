package by.it_academy.jd2.jsp.api.servlets;

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
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@WebServlet(name = "MessengerServlet", urlPatterns = "/api/message")
public class MessengerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            writer.write("кто ты такой чтобы читать сообщения? Залогинься!");
            return;
        }

        MessageService messageService = MessageService.getInstance();
        List<Message> message = messageService.getMessage(user);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if(message != null) {
            for (Message message1 : message) {
                writer.write("<p>" + message1.getFrom() + ", ");
                writer.write(message1.getDateTime().format(dateTimeFormatter) + "</p>");
                writer.write("<p>" + message1.getTextMessage() + "</p></br></br>");
            }

        } else writer.write("сообщений для вас нету");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String redirect = req.getContextPath() + "/ui?mess=message send complete";


        String to = req.getParameter("to");
        String message1 = req.getParameter("message");


        MessageService messageService = MessageService.getInstance();
        try {
            if(user == null){
            redirect = req.getContextPath() + "/ui/user/message?mess=Who are you? signIn!!";
             }else{
                Message message = new Message(user.getLogin(), to, message1 );
                messageService.sendMessage(message);
             }

        } catch (ClassNotFoundException e) {
            redirect = req.getContextPath() + "/ui/user/message?mess=" + e.getMessage();
        }finally {
            resp.sendRedirect(redirect);
        }


    }
}
