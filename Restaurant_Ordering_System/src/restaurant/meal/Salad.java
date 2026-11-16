package restaurant.meal;

public class Salad implements Meal {
    @Override public String getDescription() { return "Caesar Salad"; }
    @Override public double getPrice() { return 1800; }
}
