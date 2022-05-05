package by.it_academy.jd2.aviasales.servlets;

import by.it_academy.jd2.aviasales.dao.airport.AirportPoolDao;
import by.it_academy.jd2.aviasales.dao.airport.IAirportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try(IAirportDao dao = new AirportPoolDao()){
          req.setAttribute("airports", dao.getAll());
      }catch (Exception e){

      }

        req.getRequestDispatcher("/aviasales/jsp/airports.jsp").forward(req, resp);

    }
}
