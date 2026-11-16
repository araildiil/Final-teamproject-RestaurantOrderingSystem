package restaurant.facade;

import restaurant.meal.Meal;
import restaurant.order.Order;

public class Kitchen {
    public void cook(Order order) {
        for (Meal m : order.getMeals()) {
            System.out.println("    cooking: " + m.getDescription());
        }
    }
}
