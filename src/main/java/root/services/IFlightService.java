package root.services;

import root.model.Flight;


import java.util.List;

public interface IFlightService {
    AddFlightResult addFlight(Flight flight);
        Flight getFlightByDepartures(String departuresDate, String departuresHour);
        Flight getFlightById(int id);
        void updateFlight(Flight flight);
        List<Flight> getFlightsByCategoryWithFilter(String category);

enum AddFlightResult {
    PLACES_ADDED,
    FLIGHT_ADDED
}
}