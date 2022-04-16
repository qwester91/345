package by.it_academy.jd2.jsp.api.core.dto;


import java.time.LocalDateTime;

public class Message {
   private String from;
   private String to;
   private LocalDateTime dateTime;
   private String textMessage;

    public Message() {
    }

    public Message(String from, String to, String textMessage) {
        this.from = from;
        this.to = to;
        this.dateTime = LocalDateTime.now();
        this.textMessage = textMessage;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }


}
