package by.it_academy.jd2.aviasales.dao.flights;

import by.it_academy.jd2.aviasales.service.FlightFilter;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao{

    private DataSource ds;
    private final String QUERY = " SELECT flight_id,\n" +
            "                flight_no,\n" +
            "                scheduled_departure,\n" +
            "                scheduled_arrival,\n" +
            "                departure_airport,\n" +
            "                arrival_airport,\n" +
            "                status,\n" +
            "                aircraft_code,\n" +
            "                actual_departure,\n" +
            "                actual_arrival\n" +
            "        FROM bookings.flights\n" ;

    public FlightDao(){
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try{
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e){
            throw  new RuntimeException("проверь имя драйвера");
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");
        pool.setMaxPoolSize(20);

        this.ds = pool;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);
             )
        {
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    list.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return list;

    }

    @Override
    public Flight get(Integer flight_id) {
        String query = QUERY + "WHERE flight_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
        )
        {
            statement.setInt(1,  flight_id );
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return map(resultSet);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Flight> getFromQuery(String query) {
        List<Flight> flights = new ArrayList<>();




        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
            flights.add(map(resultSet));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return flights;

    }
    private Flight map(ResultSet rs) throws SQLException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

        LocalDateTime scheduled_departure = null;
        LocalDateTime actual_departure = null;
        LocalDateTime scheduled_arrival = null;
        LocalDateTime actual_arrival = null;

        if(rs.getString("actual_departure") != null) {
            actual_departure = LocalDateTime.parse(rs.getString("actual_departure"), formatter);
        }

        if(rs.getString("scheduled_departure") != null){
            scheduled_departure = LocalDateTime.parse(rs.getString("scheduled_departure"), formatter);
        }

        if(rs.getString("scheduled_arrival") != null){
            scheduled_arrival = LocalDateTime.parse(rs.getString("scheduled_arrival"), formatter);
        }

        if(rs.getString("actual_arrival") != null){
            actual_arrival = LocalDateTime.parse(rs.getString("actual_arrival"), formatter);
        }
        return new Flight(
                rs.getInt("flight_id"),
                rs.getString("flight_no"),
                scheduled_departure,
                scheduled_arrival,
                rs.getString("departure_airport"),
                rs.getString("arrival_airport"),
                rs.getString("status"),
                rs.getString("aircraft_code"),
                actual_departure,
                actual_arrival);



    }

    public int getCountQuery(String query){
        int count = 0;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return count;


    }

    private Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    @Override
    public void close() throws Exception {
        ((ComboPooledDataSource)ds).close();


    }
}
