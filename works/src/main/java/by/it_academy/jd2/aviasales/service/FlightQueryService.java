package by.it_academy.jd2.aviasales.service;

public class FlightQueryService {

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

     private final String QUERY_COUNT = " SELECT COUNT (*) as count" +
             "        FROM bookings.flights\n" ;



    public String getQUERY() {
        return QUERY;
    }

    public String getQueryFiltered(FlightFilter filter, int limit, int offset){
        StringBuffer buffer = new StringBuffer();
        buffer.append(QUERY);
        if(filter.isFilter()){
            buffer.append("WHERE ");
            if(!"".equals(filter.getArrAirport())){
                buffer.append("arrival_airport = '" + filter.getArrAirport() +"'");
                if (!"".equals(filter.getArrDate()) || !"".equals(filter.getDepDate()) || !"".equals(filter.getDepAirport())){
                    buffer.append(" AND ");
                }
            }
            if (!"".equals(filter.getArrDate())){
                buffer.append("scheduled_arrival::DATE = '" + filter.getArrDate() +"'");
                if (!"".equals(filter.getDepDate()) || !"".equals(filter.getDepAirport())){
                    buffer.append(" AND ");
                }
            }
            if(!"".equals(filter.getDepAirport())){
                buffer.append("departure_airport = '" + filter.getDepAirport() +"'");
                if (!"".equals(filter.getDepDate())) {
                    buffer.append(" AND ");
                }
            }
            if (!"".equals(filter.getDepDate())){
                buffer.append("scheduled_departure::DATE = '" + filter.getDepDate() +"'\n");
            }
        }buffer.append("LIMIT " + limit + " OFFSET " + offset + ";");

        String query = buffer.toString();
        return query;
    }

    public String getQueryCount(FlightFilter filter){
        StringBuffer buffer = new StringBuffer();
        buffer.append(QUERY_COUNT);
        if(filter.isFilter()){
            buffer.append("WHERE ");
            if(!"".equals(filter.getArrAirport())){
                buffer.append("arrival_airport = '" + filter.getArrAirport() +"'");
                if (!"".equals(filter.getArrDate()) || !"".equals(filter.getDepDate()) || !"".equals(filter.getDepAirport())){
                    buffer.append(" AND ");
                }
            }
            if (!"".equals(filter.getArrDate())){
                buffer.append("scheduled_arrival::DATE = '" + filter.getArrDate() +"'");
                if (!"".equals(filter.getDepDate()) || !"".equals(filter.getDepAirport())){
                    buffer.append(" AND ");
                }
            }
            if(!"".equals(filter.getDepAirport())){
                buffer.append("departure_airport = '" + filter.getDepAirport() +"'");
                if (!"".equals(filter.getDepDate())){
                    buffer.append(" AND ");

                }
            }
            if (!"".equals(filter.getDepDate())){
                buffer.append("scheduled_departure::DATE = '" + filter.getDepDate() +"'");
            }
        }buffer.append(";");

        String query = buffer.toString();
        return query;
    }

    public int getCountPages(int count){
        int result = count/25;
        if (count % 25 != 0 || count == 0){
            return ++result;
        }
        return result;
    }


}
