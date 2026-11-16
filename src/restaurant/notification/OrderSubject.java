package restaurant.notification;

public interface OrderSubject {
    void registerObserver(OrderObserver o);
    void removeObserver(OrderObserver o);
    void notifyObservers(String orderId, OrderStatus status);
}