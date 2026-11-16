package restaurant.discount;

public class DiscountContext {
    private DiscountStrategy strategy = new NoDiscount();

    public void setStrategy(DiscountStrategy strategy) { this.strategy = strategy; }
    public DiscountStrategy getStrategy() { return strategy; }

    public double calculate(double total) {
        return strategy.applyDiscount(total);
    }

    public static DiscountStrategy fromName(String name) {
        switch (name.trim().toLowerCase()) {
            case "student":   return new StudentDiscount();
            case "happyhour": return new HappyHourDiscount();
            case "big":       return new BigOrderDiscount();
            default:          return new NoDiscount();
        }
    }
}
