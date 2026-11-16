package restaurant.discount;

public class StudentDiscount implements DiscountStrategy {
    @Override public double applyDiscount(double total) { return total * 0.85; }
    @Override public String getName() { return "Student discount (15%)"; }
}
