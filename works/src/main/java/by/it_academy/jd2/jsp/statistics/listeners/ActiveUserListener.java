package by.it_academy.jd2.jsp.statistics.listeners;

import by.it_academy.jd2.jsp.statistics.StatisticsService;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ActiveUserListener implements HttpSessionAttributeListener {
    private final StatisticsService statisticsService = StatisticsService.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")){

            statisticsService.addActive();
            System.out.println("op+");

        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")){

            statisticsService.redActive();
            System.out.println("op-");

        }

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
