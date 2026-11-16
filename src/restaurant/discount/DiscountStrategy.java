package restaurant.discount;

public interface DiscountStrategy {
    double applyDiscount(double total);
    String getName();
}
