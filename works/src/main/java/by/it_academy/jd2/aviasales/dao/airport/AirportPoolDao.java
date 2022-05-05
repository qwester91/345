package by.it_academy.jd2.aviasales.dao.airport;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao implements IAirportDao{
   private DataSource ds;

   public AirportPoolDao(){
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

   public List<Airport> getAll(){
      List<Airport> list = new ArrayList<>();

      try (Connection connection = getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultset =statement.executeQuery("SELECT\n" +
                   "    airport_code,\n" +
                   "    airport_name,\n" +
                   "    city,\n" +
                   "    coordinates,\n" +
                   "    timezone\n" +
                   "FROM\n" +
                   "    bookings.airports\n"+
                   "ORDER BY city;"

           );
      ) {
         while (resultset.next()){
            list.add(map(resultset));

         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }return list;
   }

   public Airport get (String code){

      try(Connection connection = getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT\n" +
                 "    airport_code,\n" +
                 "    airport_name,\n" +
                 "    city,\n" +
                 "    coordinates,\n" +
                 "    timezone\n" +
                 "FROM\n" +
                 "    bookings.airports\n" +
                 "WHERE airport_code = '" + code + "';"
         );
      )  {
             while (resultSet.next()){
                return map(resultSet);
             }

          } catch (SQLException e){
         throw new RuntimeException(e);
      }
      return null;
   }
   private Airport map(ResultSet rs) throws SQLException{
      return new Airport(rs.getString("airport_code"),
              rs.getString("airport_name"),
              rs.getString("city"),
              rs.getString("coordinates"),
              rs.getString("timezone"));

   }

   private Connection getConnection() throws SQLException{
      return ds.getConnection();
   }

   @Override
   public void close() throws Exception {
      ((ComboPooledDataSource)ds).close();
   }
}
