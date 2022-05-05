package by.it_academy.jd2.jsp.api.service.api;

import by.it_academy.jd2.jsp.api.core.dto.Message;
import by.it_academy.jd2.jsp.api.core.dto.User;

import java.util.List;

public interface IMessageService {



    void sendMessage(Message message) throws ClassNotFoundException;

    List<Message> getMessage(User user);
}
