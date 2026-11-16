package restaurant.meal.decorator;
import restaurant.meal.Meal;

public class ExtraCheese extends MealDecorator {
    public ExtraCheese(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + " +Extra Cheese"; }
    @Override public double getPrice() {
        return meal.getPrice() + 400;
    }
}
