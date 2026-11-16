package restaurant.discount;

public class HappyHourDiscount implements DiscountStrategy {
    @Override public double applyDiscount(double total) { return total * 0.80; }
    @Override public String getName() { return "Happy hour (20%)"; }
}
