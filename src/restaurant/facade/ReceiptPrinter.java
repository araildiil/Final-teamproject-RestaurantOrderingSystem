package restaurant.facade;

import restaurant.meal.Meal;
import restaurant.order.Order;

public class ReceiptPrinter {
    public void print(Order order) {
        System.out.println("  ---------------- RECEIPT " + order.getOrderId() + " ----------------");
        System.out.println("  Customer: " + order.getCustomerName() + "   Service: " + order.getServiceType());
        if (!order.getAddress().isEmpty()) System.out.println("  Address: " + order.getAddress());
        for (Meal m : order.getMeals()) {
            System.out.printf("  %-42s %8.0f KZT%n", m.getDescription(), m.getPrice());
        }
        if (order.getServiceType().equals("DELIVERY")) System.out.printf("  %-42s %8.0f KZT%n", "Delivery fee", 700.0);
        if (!order.getNote().isEmpty()) System.out.println("  Note: " + order.getNote());
        System.out.printf("  Subtotal: %.0f KZT%n", order.getSubtotal());
        System.out.println("  Discount: " + order.getDiscount().getName());
        System.out.printf("  TOTAL:    %.0f KZT%n", order.getTotal());
        System.out.println("  ------------------------------------------------------");
    }
}
