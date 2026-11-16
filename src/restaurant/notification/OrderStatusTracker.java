package restaurant.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStatusTracker implements OrderSubject {
    private final List<OrderObserver> observers = new ArrayList<>();
    private final Map<String, OrderStatus> statuses = new HashMap<>();

    @Override public void registerObserver(OrderObserver o) { observers.add(o); }
    @Override public void removeObserver(OrderObserver o) { observers.remove(o); }

    @Override
    public void notifyObservers(String orderId, OrderStatus status) {
        for (OrderObserver o : observers) {
            o.update(orderId, status);
        }
    }

    public void setStatus(String orderId, OrderStatus status) {
        statuses.put(orderId, status);
        notifyObservers(orderId, status);
    }

    public OrderStatus getStatus(String orderId) {
        return statuses.get(orderId);
    }
}
