package restaurant.notification;

public class CustomerNotifier implements OrderObserver {
    private final String customerName;

    public CustomerNotifier(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String orderId, OrderStatus status) {
        System.out.println("  [SMS to " + customerName + "]  Your order " + orderId + " is now " + status);
    }
}
