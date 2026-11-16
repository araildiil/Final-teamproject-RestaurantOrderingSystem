package restaurant.notification;

public interface OrderObserver {
    void update(String orderId, OrderStatus status);
}
