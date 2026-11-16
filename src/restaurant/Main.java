package restaurant;

import restaurant.discount.DiscountContext;
import restaurant.discount.HappyHourDiscount;
import restaurant.discount.StudentDiscount;
import restaurant.facade.RestaurantFacade;
import restaurant.meal.Meal;
import restaurant.meal.MealFactory;
import restaurant.meal.MealType;
import restaurant.meal.decorator.Bacon;
import restaurant.meal.decorator.ExtraCheese;
import restaurant.meal.decorator.Jalapeno;
import restaurant.meal.decorator.ToppingFactory;
import restaurant.order.Order;
import restaurant.order.OrderDirector;
import restaurant.order.OrderBuilder;
import restaurant.order.StandardOrderBuilder;

import java.util.Scanner;

public class Main {
    private static final MealFactory factory = new MealFactory();
    private static final RestaurantFacade restaurant = new RestaurantFacade();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== RESTAURANT ORDERING SYSTEM =====");
            System.out.println("1. Run demo (all 6 patterns)");
            System.out.println("2. Make my own order");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            if (!in.hasNextLine()) return;
            String choice = in.nextLine().trim();
            try {
                if (choice.equals("1")) runDemo();
                else if (choice.equals("2")) customOrder(in);
                else if (choice.equals("0")) return;
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void runDemo() {
        System.out.println("\n### 1) Factory + Decorator: Burger with cheese, bacon and jalapeno");
        Meal burger = factory.createMeal(MealType.BURGER);
        burger = new ExtraCheese(burger);
        burger = new Bacon(burger);
        burger = new Jalapeno(burger);
        System.out.printf("   %s = %.0f KZT%n", burger.getDescription(), burger.getPrice());

        System.out.println("\n### 2) Builder + Strategy: delivery order with student discount");
        Order order = new StandardOrderBuilder()
                .setCustomer("Aruzhan")
                .addMeal(burger)
                .addMeal(factory.createMeal(MealType.SALAD))
                .delivery("Mangilik El 55/11")
                .setNote("No onions")
                .setDiscount(new StudentDiscount())
                .build();

        System.out.println("\n### 3) Facade + Observer: place order with one call");
        restaurant.placeOrder(order, "Kaspi QR");

        System.out.println("\n### 4) Director + another Strategy (Happy hour)");
        OrderBuilder b = new StandardOrderBuilder().setDiscount(new HappyHourDiscount());
        Order combo = new OrderDirector().buildFamilyCombo(b, "Daniyar");
        restaurant.placeOrder(combo, "Card");
    }

    private static void customOrder(Scanner in) {
        OrderBuilder builder = new StandardOrderBuilder();
        System.out.print("Your name: ");
        builder.setCustomer(in.nextLine());

        while (true) {
            System.out.print("Meal (burger/pizza/salad/pasta, empty = done): ");
            String type = in.nextLine().trim();
            if (type.isEmpty()) break;
            Meal meal = factory.createMeal(type);
            System.out.print("Toppings separated by comma (cheese,bacon,jalapeno,sauce) or empty: ");
            String toppings = in.nextLine().trim();
            if (!toppings.isEmpty()) {
                for (String t : toppings.split(",")) meal = ToppingFactory.addTopping(meal, t);
            }
            builder.addMeal(meal);
            System.out.printf("  added: %s (%.0f KZT)%n", meal.getDescription(), meal.getPrice());
        }

        System.out.print("Service (dinein/takeaway/delivery): ");
        String service = in.nextLine().trim().toLowerCase();
        if (service.equals("delivery")) {
            System.out.print("Address: ");
            builder.delivery(in.nextLine());
        } else if (service.equals("takeaway")) {
            builder.takeaway();
        } else {
            builder.dineIn();
        }

        System.out.print("Discount (none/student/happyhour/big): ");
        builder.setDiscount(DiscountContext.fromName(in.nextLine()));

        Order order = builder.build();
        System.out.print("Payment method (Cash/Card/Kaspi QR): ");
        restaurant.placeOrder(order, in.nextLine());
    }
}
