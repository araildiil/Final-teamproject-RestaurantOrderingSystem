package restaurant.facade;

import restaurant.notification.CustomerNotifier;
import restaurant.notification.KitchenDisplay;
import restaurant.notification.OrderStatus;
import restaurant.notification.OrderStatusTracker;
import restaurant.notification.WaiterNotifier;
import restaurant.order.Order;

public class RestaurantFacade {
    private final Kitchen kitchen = new Kitchen();
    private final PaymentService payment = new PaymentService();
    private final ReceiptPrinter printer = new ReceiptPrinter();
    private final OrderStatusTracker tracker = new OrderStatusTracker();

    public RestaurantFacade() {
        tracker.registerObserver(new KitchenDisplay());
        tracker.registerObserver(new WaiterNotifier());
    }

    public OrderStatusTracker getTracker() { return tracker; }

    public void placeOrder(Order order, String paymentMethod) {
        CustomerNotifier customer = new CustomerNotifier(order.getCustomerName());
        tracker.registerObserver(customer);

        printer.print(order);
        if (!payment.pay(order.getCustomerName(), order.getTotal(), paymentMethod)) {
            tracker.setStatus(order.getOrderId(), OrderStatus.CANCELLED);
            tracker.removeObserver(customer);
            return;
        }

        tracker.setStatus(order.getOrderId(), OrderStatus.PLACED);
        tracker.setStatus(order.getOrderId(), OrderStatus.PREPARING);
        kitchen.cook(order);
        tracker.setStatus(order.getOrderId(), OrderStatus.READY);
        tracker.setStatus(order.getOrderId(), OrderStatus.DELIVERED);

        tracker.removeObserver(customer);
    }
}
