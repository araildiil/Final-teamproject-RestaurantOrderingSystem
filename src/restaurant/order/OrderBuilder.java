package restaurant.order;

import restaurant.discount.DiscountStrategy;
import restaurant.meal.Meal;

public interface OrderBuilder {
    OrderBuilder setCustomer(String name);
    OrderBuilder addMeal(Meal meal);
    OrderBuilder dineIn();
    OrderBuilder takeaway();
    OrderBuilder delivery(String address);
    OrderBuilder setNote(String note);
    OrderBuilder setDiscount(DiscountStrategy discount);
    Order build();
}
