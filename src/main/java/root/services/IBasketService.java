package root.services;

public interface IBasketService {
    void addToBasket(int flightId);
    double calculateBill();
    void removeFlightFromBasket(int flightId);
}