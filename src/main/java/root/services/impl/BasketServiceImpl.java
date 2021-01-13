package root.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.dao.IFlightDAO;
import root.dao.IFlightDAO;
import root.model.Flight;
import root.services.IBasketService;
import root.session.SessionObject;

import javax.annotation.Resource;

@Service
public class BasketServiceImpl implements IBasketService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IFlightDAO flightDAO;

    @Override
    public void addToBasket(int flightId) {
        for(Flight flight : this.sessionObject.getBasket()) {
            if(flight.getId() == flightId) {
                flight.setPlaces(flight.getPlaces()+1);
                return;
            }
        }

        Flight flight = this.flightDAO.getFlightById(flightId);
        flight.setPlaces(1);
        this.sessionObject.getBasket().add(flight);
    }

    @Override
    public double calculateBill() {
        double bill = 0;
        for(Flight flight : this.sessionObject.getBasket()) {
            bill = bill + flight.getPrice() * flight.getPlaces();
        }
        return bill;
    }

    @Override
    public void removeFlightFromBasket(int flightId) {
        for(Flight flight : this.sessionObject.getBasket()) {
            if(flight.getId() == flightId) {
                this.sessionObject.getBasket().remove(flight);
                return;
            }
        }
    }
}