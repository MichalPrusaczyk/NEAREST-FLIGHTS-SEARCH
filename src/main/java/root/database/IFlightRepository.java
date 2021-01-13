package root.database;

import root.model.Flight;

import java.util.List;

public interface IFlightRepository {
        List<Flight> getAllFlights();

        List<Flight> getFlightsByCategory(Flight.Category category);

        Flight getFlightByDeparture(String departure);

        void addFlight(Flight flight);

        void updateFlight(Flight flight);
    }
