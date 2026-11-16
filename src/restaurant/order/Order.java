package restaurant.order;

import restaurant.discount.DiscountStrategy;
import restaurant.discount.NoDiscount;
import restaurant.meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private final List<Meal> meals = new ArrayList<>();
    private String serviceType = "DINE_IN";
    private String address = "";
    private String note = "";
    private DiscountStrategy discount = new NoDiscount();

    Order() { }

    void setOrderId(String orderId) { this.orderId = orderId; }
    void setCustomerName(String customerName) { this.customerName = customerName; }
    void addMeal(Meal meal) { meals.add(meal); }
    void setServiceType(String serviceType) { this.serviceType = serviceType; }
    void setAddress(String address) { this.address = address; }
    void setNote(String note) { this.note = note; }
    void setDiscount(DiscountStrategy discount) { this.discount = discount; }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<Meal> getMeals() { return meals; }
    public String getServiceType() { return serviceType; }
    public String getAddress() { return address; }
    public String getNote() { return note; }
    public DiscountStrategy getDiscount() { return discount; }

    public double getSubtotal() {
        double sum = 0;
        for (Meal m : meals) sum += m.getPrice();
        if (serviceType.equals("DELIVERY")) sum += 700;
        return sum;
    }

        public double getTotal() {
        return discount.applyDiscount(getSubtotal());
    }
}
