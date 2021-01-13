package root.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.dao.IFlightDAO;
import root.model.Flight;
import root.services.IFlightService;
import root.session.SessionObject;
import root.utils.FilterUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {

    @Autowired
    IFlightDAO flightDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public AddFlightResult addFlight(Flight flight) {
        Flight flightFromDB = this.flightDAO.getFlightByDepartures(flight.getDeparture());
        if(flightFromDB == null) {
            this.flightDAO.persistFlight(flight);
            return AddFlightResult.FLIGHT_ADDED;
        } else {
            flightFromDB.setPlaces(flightFromDB.getPlaces() + flight.getPlaces());
            this.flightDAO.updateFlight(flightFromDB);
            return AddFlightResult.PLACES_ADDED;
        }
    }

    @Override
    public Flight getFlightByDepartures(String departures) {
        return null;
    }



    @Override
    public Flight getFlightById(int id) {
        return this.flightDAO.getFlightById(id);
    }

    @Override
    public void updateFlight(Flight flight) {
        this.flightDAO.updateFlight(flight);
    }

    @Override
    public List<Flight> getFlightsByCategoryWithFilter(String category) {
        switch (category) {
            case "button1":
                return FilterUtils.filterFlights(this.flightDAO.getFlightsByCategory(Flight.Category.BUTTON1),
                        this.sessionObject.getFilter());
            case "button2":
                return FilterUtils.filterFlights(this.flightDAO.getFlightsByCategory(Flight.Category.BUTTON2),
                        this.sessionObject.getFilter());

            default:
                return FilterUtils.filterFlights(this.flightDAO.getAllFlights(),
                        this.sessionObject.getFilter());
        }
    }
}