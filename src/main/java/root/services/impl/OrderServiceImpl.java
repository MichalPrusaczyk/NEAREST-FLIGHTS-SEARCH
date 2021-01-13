package root.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.dao.IFlightDAO;
import root.dao.IOrderDAO;
import root.model.Flight;
import root.model.Order;
import root.model.OrderPosition;
import root.services.IOrderService;
import root.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IFlightDAO flightDAO;

    @Autowired
    IOrderDAO orderDAO;

    @Override
    public void confirmOrder() {
        //Pobieramy koszyk
        List<Flight> orderedFlights = this.sessionObject.getBasket();

        for(Flight flightFromBasket : orderedFlights) {
            Flight flightFromDB = this.flightDAO.getFlightById(flightFromBasket.getId());
            if(flightFromDB.getLength() < flightFromBasket.getLength()) {
                return;
            }
        }

        //tworzymy zamowienie
        Order order = new Order();
        //dodajemy usera do zamowienia
        order.setUser(this.sessionObject.getUser());
        //wyliczamy kwote zamowienia
        double bill = 0;
        for(Flight flight : orderedFlights) {
            bill = bill + flight.getPrice() * flight.getLength();
        }
        order.setPrice(bill);
        //ustawiamy status zamowienia
        order.setStatus(Order.Status.ORDERED);
        //tworzymy pozycje zamowienia na podstawie koszyka
        for(Flight flight : orderedFlights) {
            OrderPosition orderPosition = new OrderPosition();
            orderPosition.setLength(flight.getLength());
            orderPosition.setOrder(order);
            orderPosition.setFlight(flight);

            order.getPositions().add(orderPosition);
        }

        this.orderDAO.persistOrder(order);

        for(Flight flight : orderedFlights) {
            Flight flightFromDB = this.flightDAO.getFlightById(flight.getId());
            flightFromDB.setLength(flightFromDB.getLength() - flight.getLength());
            this.flightDAO.updateFlight(flightFromDB);
        }

        this.sessionObject.getBasket().clear();
    }

    @Override
    public List<Order> getOrdersForCurrentUser() {
        return this.orderDAO.getOrdersByUser(this.sessionObject.getUser().getId());
    }
}