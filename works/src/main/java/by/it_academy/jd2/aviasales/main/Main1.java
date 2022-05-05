package by.it_academy.jd2.aviasales.main;

import by.it_academy.jd2.aviasales.dao.airport.Airport;
import by.it_academy.jd2.aviasales.dao.airport.AirportDao;
import by.it_academy.jd2.aviasales.dao.airport.IAirportDao;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }

        IAirportDao airportDao = new AirportDao();

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
