package restaurant.meal.decorator;
import restaurant.meal.Meal;

public class Jalapeno extends MealDecorator {
    public Jalapeno(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + " + Jalapeno"; }
    @Override public double getPrice() { return meal.getPrice() + 300; }
}
