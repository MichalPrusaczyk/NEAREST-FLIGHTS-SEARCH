package root.database.impl;

import org.springframework.stereotype.Component;
import root.database.IFlightRepository;
import root.model.Flight;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListFlightRepositoryImpl implements IFlightRepository {

    private final List<Flight> flights = new ArrayList<>();

//    {
//        this.product.add(new Product("Aluminium", "round", 100, "fi10",200.00, Product.Category.BUTTON1,"123123123"));
//        this.product.add(new Product("Steel", "round", 100, "fi10",100.00, Product.Category.BUTTON2,"456456456"));
//    }


    @Override
    public List<Flight> getAllFlights() {
        return this.flights;
    }

    @Override
    public List<Flight> getFlightsByCategory(Flight.Category category) {
        //TODO Do zrobienia
        return null;
    }

    @Override
    public Flight getFlightByEAN(String ean) {
        for(Flight flight : this.flights) {
            if(flight.getEan().equals(ean)) {
                return flight;
            }
        }

        return null;
    }

    @Override
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        //TODO do zrobienia
    }
}
