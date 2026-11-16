package restaurant.meal;

public class Pasta implements Meal {
    @Override public String getDescription() { return "Pasta Carbonara"; }
    @Override public double getPrice() { return 3000; }
}
