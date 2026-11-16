package restaurant.facade;

public class PaymentService {
    public boolean pay(String customer, double amount, String method) {
        System.out.printf("    payment: %s paid %.0f KZT by %s%n", customer, amount, method);
        return amount > 0;
    }
}
