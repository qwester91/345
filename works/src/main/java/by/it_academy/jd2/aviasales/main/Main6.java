package by.it_academy.jd2.aviasales.main;

import by.it_academy.jd2.aviasales.dao.flights.Flight;
import by.it_academy.jd2.aviasales.dao.flights.FlightDao;
import by.it_academy.jd2.aviasales.dao.flights.IFlightDao;
import by.it_academy.jd2.aviasales.service.FlightQueryService;

import java.util.List;

public class Main6 {
    public static void main(String[] args) {
        FlightQueryService service = new FlightQueryService();
        System.out.println(service.getCountPages(76));
    }
}
