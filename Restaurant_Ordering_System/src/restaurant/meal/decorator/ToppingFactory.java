package restaurant.meal.decorator;
import restaurant.meal.Meal;

public class ToppingFactory {
    public static Meal addTopping(Meal meal, String topping) {
        switch (topping.trim().toLowerCase()) {
            case "cheese":   return new ExtraCheese(meal);
            case "bacon":    return new Bacon(meal);
            case "jalapeno": return new Jalapeno(meal);
            case "sauce":    return new ExtraSauce(meal);
            default: throw new IllegalArgumentException("Unknown topping: " + topping);
        }
    }
}
