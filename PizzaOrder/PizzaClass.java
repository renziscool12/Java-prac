package practice2;

import java.util.*;

public class Pizza {
    // enum for pizza size
    public enum PizzaSize {
        SMALL,
        MEDIUM,
        LARGE,
        XLARGE
    }

    // enum for pizza type
    public enum PizzaType {
        PEPPERONI,
        CHEESY,
        HAWAIIAN,
        NEAPOLITAN
    }

    public enum Toppings {
        BACON,
        OLIVES,
        SAUSAGE,
        ONIONS,
        NONE
    }

    // fields
    PizzaSize size;
    PizzaType type;
    private List<Toppings> toppings;
    private double price;
    private int quantity;
    // random generator for random pizza static field to be used in randomPizza()
    // method
    private static final Random rand = new Random();

    // constructor
    public Pizza(PizzaSize size, PizzaType type, List<Toppings> toppings, int quantity) {
        this.size = size;
        this.type = type;
        this.toppings = new ArrayList<>(toppings); // defense copy
        this.quantity = quantity;
        this.price = basePrice(); // price of 1 pizza (size + type + toppings)
    }

    // getter
    // Make sure to calculate each pizza's price only once and add it to the total.
    // Do not call getPriceForPizza() multiple times per pizza unless intended.
    // Always initialize your total price before summing multiple pizzas to avoid
    // inflation.
    // always initialize another variable if you want total all prices of the items
    // Calculate base price of a single pizza
    public double basePrice() {
        double totalPrice = 0;
        switch (size) {
            case SMALL:
                totalPrice += 45.2;
                break;
            case MEDIUM:
                totalPrice += 49.3;
                break;
            case LARGE:
                totalPrice += 54.5;
                break;
            case XLARGE:
                totalPrice += 60.22;
                break;
            default:
                throw new IllegalArgumentException("Invalid!");
        }

        switch (type) {
            case PEPPERONI:
                totalPrice += 55.3;
                break;
            case CHEESY:
                totalPrice += 61.1;
                break;
            case HAWAIIAN:
                totalPrice += 66.2;
                break;
            case NEAPOLITAN:
                totalPrice += 70.7;
                break;
            default:
                throw new IllegalArgumentException("Invalid!");
        }
        // Add toppings price each topping = 6
        totalPrice += toppings.size() * 6; // 6 peso per each topping
        return totalPrice * quantity; // price for 1 pizza * quantity
    }

    // getters
    public double getPrice() {
        return this.price;
    }

    public PizzaType getType() {
        return type;
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<Toppings> getToppings() {
        return new ArrayList<>(toppings); // return defensive copy
    }

    public int getQuantity() {
        return this.quantity;
    }

    public static Pizza randomPizza() {
        // Picks random size and type for pizza
        PizzaSize size = PizzaSize.values()[rand.nextInt(PizzaSize.values().length)];
        PizzaType type = PizzaType.values()[rand.nextInt(PizzaType.values().length)];

        // Randomly select toppings for pizza 0 to 4 toppings
        List<Toppings> toppings = new ArrayList<>();
        // Array for all toppings to randomly select form, and a random number of
        // toppings to add to the pizza
        Toppings[] allToppings = Toppings.values();
        // Randomly determine how many toppings to add 0 to 4 toppings
        int toppingCount = rand.nextInt(5);
        // For loop to add random toppings to the pizza, ensuring no duplicates and not
        // exceeding the topping count
        for (int i = 0; i < toppingCount; i++) {
            Toppings e = allToppings[rand.nextInt(allToppings.length)];
            // if statement to check if the randomly selected topping is not NONE, not
            // already in the toppings list, and does not exceed the topping count before
            // adding it to the pizza
            if (e != Toppings.NONE && !toppings.contains(e) && toppings.size() < toppingCount) {
                toppings.add(e);
            }
        }
        int quantity = rand.nextInt(5) + 1; // random quantity between 1 and 5
        return new Pizza(size, type, toppings, quantity);

    }

    public static void Menu() {
        System.out.println("---Pandita's Pizza---");
        System.out.println("[1] Order Pizza");
        System.out.println("[2] View Order");
        System.out.println("[3] Cancel Order");
        System.out.println("[4] Total orders");
        System.out.println("[5] Save Receipt");
        System.out.println("[6] Surprise me, give me a random Pizza!");
        System.out.println("[7] Exit");
        System.out.print("Your choice: ");
    }

    @Override
    public String toString() {
        return String.format("Size: %s Type: %s with %s x %d | Price: %.2f", size, type, toppings, quantity, price);
    }
}
