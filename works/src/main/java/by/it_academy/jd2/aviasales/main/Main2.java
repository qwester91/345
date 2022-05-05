package by.it_academy.jd2.aviasales.main;

import by.it_academy.jd2.aviasales.dao.airport.Airport;
import by.it_academy.jd2.aviasales.dao.airport.AirportPoolDao;
import by.it_academy.jd2.aviasales.dao.airport.IAirportDao;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        IAirportDao airportDao = new AirportPoolDao();

        long start = System.currentTimeMillis();
        List<Airport> airports = airportDao.getAll();
        long stop = System.currentTimeMillis();


        //Время получения всех списком
        System.out.println(stop - start);

        start = System.currentTimeMillis();
        for (Airport airport : airports) {
            airportDao.get(airport.getAirport_code());
        }
        stop = System.currentTimeMillis();

        //время получения всех по одной
        System.out.println(stop - start);
    }
}
