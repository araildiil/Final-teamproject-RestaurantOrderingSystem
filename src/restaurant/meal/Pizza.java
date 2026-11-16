package restaurant.meal;

public class Pizza implements Meal {
    @Override public String getDescription() { return "Pizza"; }
    @Override public double getPrice() { return 3500; }
}
