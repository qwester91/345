package by.it_academy.jd2.aviasales.servlets;

import by.it_academy.jd2.aviasales.dao.airport.Airport;
import by.it_academy.jd2.aviasales.dao.airport.AirportPoolDao;
import by.it_academy.jd2.aviasales.dao.flights.Flight;
import by.it_academy.jd2.aviasales.dao.flights.FlightDao;
import by.it_academy.jd2.aviasales.service.FlightFilter;
import by.it_academy.jd2.aviasales.service.FlightQueryService;
import by.it_academy.jd2.aviasales.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightServlet", urlPatterns = "/flights")
public class FlightServlet extends HttpServlet {
   private final String DEPARTURE_DATE = "departureDate";
   private final String DEPARTURE_AIRPORT = "departureAirport";
   private final String ARRIVAL_DATE = "arrivalDate";
   private final String ARRIVAL_AIRPORT = "arrivalAirport";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String depDate = req.getParameter(DEPARTURE_DATE);
        String depAirport = req.getParameter(DEPARTURE_AIRPORT);
        String arrDate = req.getParameter(ARRIVAL_DATE);
        String arrAirport = req.getParameter(ARRIVAL_AIRPORT);
        FlightFilter flightFilter = new FlightFilter(depDate, depAirport, arrDate, arrAirport);
        FlightService service = new FlightService(flightFilter);
        int countPages = service.getCountPages();
        String page = req.getParameter("page");
        if (page ==null || page.equals("")){
            page = "1";
            req.setAttribute("page", 1);
        } else {
            req.setAttribute("page", Integer.parseInt(page));
        }
        List<Flight> listFlight = service.getListFlight(Integer.parseInt(page+1));


        req.setAttribute("flightList", listFlight);
        req.setAttribute("countpages", countPages);





        req.getRequestDispatcher("/aviasales/jsp/flightSheet.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");


        List<Airport> all;
        try (AirportPoolDao airportPoolDao = new AirportPoolDao()) {
            all = airportPoolDao.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("airports", all);


        req.getRequestDispatcher("/aviasales/jsp/flights.jsp").forward(req, resp);

    }
}
