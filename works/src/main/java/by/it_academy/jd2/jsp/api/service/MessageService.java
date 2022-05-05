package by.it_academy.jd2.jsp.api.service;

import by.it_academy.jd2.jsp.api.core.dto.Message;
import by.it_academy.jd2.jsp.api.core.dto.User;
import by.it_academy.jd2.jsp.api.service.api.IMessageService;
import by.it_academy.jd2.jsp.statistics.StatisticsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private Map<User, List<Message>> messageMap;

    private final StatisticsService statisticsService = StatisticsService.getInstance();
    private static final MessageService instance = new MessageService();

    private MessageService() {
        messageMap = new HashMap<>();    }

    public static MessageService getInstance() {
        return instance;
    }

    @Override
    public void sendMessage(Message message) throws ClassNotFoundException {
        UserService userService = UserService.getInstance();
        User userTo = userService.getUser(message.getTo());
        List<Message> messageList;
        if (messageMap.containsKey(userTo)) {
            messageList = messageMap.getOrDefault(userTo, new ArrayList<>());
        }else {
            messageList = new ArrayList<>();            
        }
        messageList.add(message);
        messageMap.put(userTo, messageList);
        statisticsService.addCountMessage();
    }

    @Override
    public List<Message> getMessage(User user){
        List <Message> messages = null;
        if (messageMap.containsKey(user)){
            messages = messageMap.get(user);
        }
        return messages;
    }

}
