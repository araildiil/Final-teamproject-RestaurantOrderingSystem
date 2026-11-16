package restaurant.notification;

public class WaiterNotifier implements OrderObserver {
    @Override
    public void update(String orderId, OrderStatus status) {
        if (status == OrderStatus.READY) {
            System.out.println("  [WAITER]   Pick up order " + orderId + " from the kitchen!");
        }
    }
}
