package restaurant.meal.decorator;
import restaurant.meal.Meal;

public class Bacon extends MealDecorator {
    public Bacon(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + "+Bacon"; }
    @Override public double getPrice()
    {return meal.getPrice() + 600;}
}
