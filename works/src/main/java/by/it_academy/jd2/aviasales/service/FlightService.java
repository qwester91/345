package by.it_academy.jd2.aviasales.service;

import by.it_academy.jd2.aviasales.dao.flights.Flight;
import by.it_academy.jd2.aviasales.dao.flights.FlightDao;

import java.util.List;

public class FlightService {

    private final FlightFilter filter;

    public FlightService(FlightFilter filter) {
        this.filter = filter;
    }

    public List<Flight> getListFlight (int page){
        List<Flight> flights = null;
        FlightQueryService queryService = new FlightQueryService();
        try (FlightDao flightDao = new FlightDao()) {

            String queryFiltered = queryService.getQueryFiltered(filter, 25, (page - 1) * 25);
            flights = flightDao.getFromQuery(queryFiltered);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    public int getCountPages(){
        FlightQueryService queryService = new FlightQueryService();
        int countQuery;
        try (FlightDao flightDao = new FlightDao()) {
            String queryCount = queryService.getQueryCount(filter);
            countQuery = flightDao.getCountQuery(queryCount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return
        queryService.getCountPages(countQuery);
    }
}
