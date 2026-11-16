package restaurant.order;

import restaurant.meal.Meal;
import restaurant.meal.MealFactory;
import restaurant.meal.MealType;
import restaurant.meal.decorator.ExtraCheese;
import restaurant.meal.decorator.ExtraSauce;

public class OrderDirector {
    private final MealFactory factory = new MealFactory();

    public Order buildFamilyCombo(OrderBuilder builder, String customer) {
        Meal pizza = new ExtraCheese(factory.createMeal(MealType.PIZZA));
        return builder.setCustomer(customer)
                .addMeal(pizza)
                .addMeal(factory.createMeal(MealType.BURGER))
                .addMeal(factory.createMeal(MealType.BURGER))
                .addMeal(factory.createMeal(MealType.SALAD))
                .dineIn()
                .setNote("Family combo")
                .build();
    }

    public Order buildLunchCombo(OrderBuilder builder, String customer) {
        Meal pasta = new ExtraSauce(factory.createMeal(MealType.PASTA));
        return builder.setCustomer(customer)
                .addMeal(pasta)
                .addMeal(factory.createMeal(MealType.SALAD))
                .takeaway()
                .setNote("Lunch combo")
                .build();
    }
}
