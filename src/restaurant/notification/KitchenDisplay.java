package restaurant.notification;

public class KitchenDisplay implements OrderObserver {
    @Override
    public void update(String orderId, OrderStatus status) {
        if (status == OrderStatus.PLACED) {
            System.out.println("  [KITCHEN]  New order " + orderId + " - start cooking!");
        } else if (status == OrderStatus.CANCELLED) {
            System.out.println("  [KITCHEN]  Order " + orderId + " cancelled - stop cooking.");
        } else {
            System.out.println("  [KITCHEN]  Order " + orderId + " -> " + status);
        }
    }
}
