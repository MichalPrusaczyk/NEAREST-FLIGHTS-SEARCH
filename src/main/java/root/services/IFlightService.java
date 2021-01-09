package root.services;

import root.model.Flight;


import java.util.List;

public interface IFlightService {
    AddFlightResult addFlight(Flight flight);
        Flight getFlightByEAN(String ean);
        Flight getFlightById(int id);
        void updateFlight(Flight flight);
        List<Flight> getFlightsByCategoryWithFilter(String category);

enum AddFlightResult {
    LENGTH_ADDED,
    FLIGHT_ADDED
}
}