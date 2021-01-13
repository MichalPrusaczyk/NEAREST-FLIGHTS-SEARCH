package root.dao;

import root.model.Flight;

import java.util.List;

public interface IFlightDAO {
    Flight getFlightByDepartures(String departures);
    void updateFlight(Flight flight);
    void persistFlight(Flight flight);
    Flight getFlightById(int id);
    List<Flight> getFlightsByCategory(Flight.Category category);
    List<Flight> getAllFlights();
}