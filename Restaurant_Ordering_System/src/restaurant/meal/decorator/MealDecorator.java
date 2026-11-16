package restaurant.meal.decorator;
import restaurant.meal.Meal;

public abstract class MealDecorator implements Meal {
    protected final Meal meal;
    protected MealDecorator(Meal meal) {
        this.meal=meal;
    }
    @Override public String getDescription() { return meal.getDescription(); }
    @Override public double getPrice() { return meal.getPrice(); }
}
