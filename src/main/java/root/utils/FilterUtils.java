package root.utils;

import root.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FilterUtils {
    public static List<Flight> filterFlights(List<Flight> flights, String filter) {
        if(filter == null) {
            return flights;
        }

        List<Flight> filteredFlights = new ArrayList<>();

        for(Flight flight : flights) {
            if(flight.getOrigin().toUpperCase().contains(filter.toUpperCase()) ||
                    flight.getDestination().toUpperCase().contains(filter.toUpperCase())) {
                filteredFlights.add(flight);
            }
        }

        return filteredFlights;
    }
}
