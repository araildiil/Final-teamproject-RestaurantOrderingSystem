# Restaurant Ordering System

Java console application for final project. It uses 6 design patterns.

| Member | Patterns | Responsibility |
|---|---|---|
| Beimzhan | Factory, Decorator | Creating meals and adding extra ingredients |
| Zhibek | Observer, Strategy | Order status notifications and discounts |
| Arailym | Builder, Facade | Building the order and placing it |

## How the patterns work together
1. Factory creates a meal
2. Decorator adds toppings (cheese, bacon, jalapeno, sauce)
3. Builder puts the meals into an order and sets the discount
4. Strategy calculates the final price
5. Facade `placeOrder()` prints the receipt, takes the payment and sends the order to the kitchen
6. Observer sends every status change to the kitchen

## Run
```
javac -d out $(find src -name "*.java")
java -cp out restaurant.Main
```

## Files

Beimzhan: `src/restaurant/meal/`
- Meal, MealType, MealFactory, Burger, Pizza, Salad, Pasta
- decorator/MealDecorator, ExtraCheese, Bacon, Jalapeno, ExtraSauce, ToppingFactory

Zhibek: `src/restaurant/notification/`, `src/restaurant/discount/`
- OrderStatus, OrderObserver, OrderSubject, OrderStatusTracker, KitchenDisplay, CustomerNotifier, WaiterNotifier
- DiscountStrategy, NoDiscount, StudentDiscount, HappyHourDiscount, BigOrderDiscount, DiscountContext

Arailym: `src/restaurant/order/`, `src/restaurant/facade/`, `src/restaurant/Main.java`
- Order, OrderBuilder, StandardOrderBuilder, OrderDirector
- RestaurantFacade, Kitchen, PaymentService, ReceiptPrinter
