package restaurant.meal.decorator;
import restaurant.meal.Meal;

public class ExtraSauce extends MealDecorator {
    public ExtraSauce(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + " + Extra Sauce"; }
    @Override public double getPrice() { return meal.getPrice() + 200; }
}
