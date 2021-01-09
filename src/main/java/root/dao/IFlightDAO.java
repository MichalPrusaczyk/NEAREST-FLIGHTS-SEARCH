package root.dao;

import root.model.Flight;

import java.util.List;

public interface IFlightDAO {
    Flight getFlightByEAN(String ean);
    void updateFlight(Flight flight);
    void persistFlight(Flight flight);
    Flight getFlightById(int id);
    List<Flight> getFlightsByCategory(Flight.Category category);
    List<Flight> getAllFlights();
}