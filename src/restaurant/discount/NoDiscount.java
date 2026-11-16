package restaurant.discount;

public class NoDiscount implements DiscountStrategy {
    @Override public double applyDiscount(double total) { return total; }
    @Override public String getName() { return "No discount"; }
}
