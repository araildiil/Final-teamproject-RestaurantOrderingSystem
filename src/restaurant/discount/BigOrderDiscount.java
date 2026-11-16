package restaurant.discount;

public class BigOrderDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total >= 10000 ? total - 1000 : total;
    }
    @Override public String getName() { return "Big order (-1000 KZT from 10000)"; }
}
