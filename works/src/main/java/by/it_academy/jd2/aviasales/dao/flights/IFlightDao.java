package by.it_academy.jd2.aviasales.dao.flights;

import by.it_academy.jd2.aviasales.service.FlightFilter;

import java.util.List;

public interface IFlightDao extends AutoCloseable {
    /**
     * получить данные о всех полетах
     * @return
     */
    List<Flight> getAll();

    /**
     * получить данные о полете по id
     * @param flight_id id полета
     * @return
     */
    Flight get (Integer flight_id);

    /**
     * аолучить данные о полете, передав sql запрос
     * @param query запрос
     * @return
     */
    List<Flight> getFromQuery(String query);
}
