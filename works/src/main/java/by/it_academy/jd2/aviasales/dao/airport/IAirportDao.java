package by.it_academy.jd2.aviasales.dao.airport;

import java.util.List;

public interface IAirportDao extends AutoCloseable {

    List<Airport> getAll();
    Airport get (String code);
}
