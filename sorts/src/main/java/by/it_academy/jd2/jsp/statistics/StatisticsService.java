package by.it_academy.jd2.jsp.statistics;

public class StatisticsService {
    private int activeUser;
    private int countUser;
    private int countMessage;
    private static final StatisticsService instance = new StatisticsService();

    private StatisticsService(){
        activeUser = 0;
        countMessage = 0;
        countUser = 1;
    }

    public static StatisticsService getInstance() {
        return instance;
    }

    public void addActive(){
       activeUser++;
    }

    public void redActive(){
        activeUser--;
    }

    public void addCountMessage(){
        countMessage++;
    }

    public void addCountUser(){
        countUser++;
    }

    public int getActiveUser() {
        return activeUser;
    }

    public int getCountUser() {
        return countUser;
    }

    public int getCountMessage() {
        return countMessage;
    }
}
