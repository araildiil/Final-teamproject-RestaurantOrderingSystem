package restaurant.order;

import restaurant.discount.DiscountStrategy;
import restaurant.meal.Meal;

public class StandardOrderBuilder implements OrderBuilder {
    private static int counter = 1;
    private Order order = new Order();

    @Override public OrderBuilder setCustomer(String name) { order.setCustomerName(name); return this; }
    @Override public OrderBuilder addMeal(Meal meal) { order.addMeal(meal); return this; }
    @Override public OrderBuilder dineIn() { order.setServiceType("DINE_IN"); return this; }
    @Override public OrderBuilder takeaway() { order.setServiceType("TAKEAWAY"); return this; }

    @Override
    public OrderBuilder delivery(String address) {
        order.setServiceType("DELIVERY");
        order.setAddress(address);
        return this;
    }

    @Override public OrderBuilder setNote(String note) { order.setNote(note); return this; }
    @Override public OrderBuilder setDiscount(DiscountStrategy d) { order.setDiscount(d); return this; }

    @Override
    public Order build() {
        if (order.getCustomerName() == null || order.getCustomerName().isBlank())
            throw new IllegalStateException("Customer name is required");
        if (order.getMeals().isEmpty())
            throw new IllegalStateException("Order must contain at least one meal");
        if (order.getServiceType().equals("DELIVERY") && order.getAddress().isBlank())
            throw new IllegalStateException("Delivery address is required");

        order.setOrderId(String.format("ORD-%03d", counter++));
        Order result = order;
        order = new Order();
        return result;
    }
}
