package by.it_academy.jd2.aviasales.service;

import java.time.LocalDateTime;

public class FlightFilter {
  private final String depDate;
  private final String depAirport;
  private final String arrDate;
  private final String arrAirport;

    public FlightFilter(String depDate, String depAirport, String arrDate, String arrAirport) {
        this.depDate = depDate;
        this.depAirport = depAirport;
        this.arrDate = arrDate;
        this.arrAirport = arrAirport;
    }

    public String getDepDate() {
        return depDate;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public String getArrDate() {
        return arrDate;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public boolean isFilter (){
        String empty = "";
        if(empty.equals(depDate) && empty.equals(depAirport) && empty.equals(arrDate) && empty.equals(arrAirport)){
            return false;
        }
        return true;
    }
}
