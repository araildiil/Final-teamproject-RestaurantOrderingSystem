package restaurant.meal;

public class MealFactory {
    public Meal createMeal(MealType type) {
        switch (type) {
            case BURGER: return new Burger();
            case PIZZA:  return new Pizza();
            case SALAD:  return new Salad();
            case PASTA:  return new Pasta();
            default: throw new IllegalArgumentException("Unknown meal type: " + type);
        }
    }
    public Meal createMeal(String type) {
        try {
            return createMeal(MealType.valueOf(type.trim().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown meal: " + type);
        }
    }
}
