package restaurant.meal;

public class Burger implements Meal {
    @Override public String getDescription() { return "Burger"; }
    @Override public double getPrice() { return 2500; }
}
