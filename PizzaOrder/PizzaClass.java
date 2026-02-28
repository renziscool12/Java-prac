package practice2;
import java.lang.IllegalArgumentException;
import java.util.*;

public class Pizza {
	//enum for pizza size
	public enum PizzaSize {
		SMALL,
		MEDIUM,
		LARGE,
		XLARGE
	}
	
	//enum for pizza type
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
	//fields
	PizzaSize size;
	PizzaType type;
	private List<Toppings> toppings;
	private double price;
	private int quantity;
	
	//constructor
	public Pizza(PizzaSize size, PizzaType type, List<Toppings> toppings, int quantity) {
		this.size = size;
		this.type = type;
		this.toppings = new ArrayList<>(toppings); //defense copy
		this.quantity = quantity;
		this.price = basePrice(); // price of 1 pizza (size + type + toppings)
	}
	
	
	//getter
	// Make sure to calculate each pizza's price only once and add it to the total.
	// Do not call getPriceForPizza() multiple times per pizza unless intended.
	// Always initialize your total price before summing multiple pizzas to avoid inflation.
	// always initialize another variable if you want total all prices of the items
	// Calculate base price of a single pizza
	public double basePrice() {
		double totalPrice = 0;
		switch(size) {
		case SMALL: totalPrice += 45.2; break;
		case MEDIUM: totalPrice += 49.3; break;
		case LARGE: totalPrice += 54.5; break;
		case XLARGE: totalPrice += 60.22; break;	
		default:
			throw new IllegalArgumentException("Invalid!");
		}
		
		switch(type) {
		case PEPPERONI: totalPrice += 55.3; break;
		case CHEESY: totalPrice += 61.1; break;
		case HAWAIIAN: totalPrice += 66.2; break;
		case NEAPOLITAN: totalPrice += 70.7; break;
		default:
			throw new IllegalArgumentException("Invalid!");
		}
		// Add toppings price each topping = 6
		totalPrice += toppings.size() * 6; // 6 peso per each topping
		return totalPrice * quantity; // price for 1 pizza * quantity
	}
	
	//getters
	public double getPrice() { return this.price; }
	public PizzaType getType() { return type; }
	public PizzaSize getSize() { return size; }
	public List<Toppings> getToppings() { return new ArrayList<>(toppings); } // return defensive copy
	public int getQuantity() { return this.quantity; }
	
	public static void Menu() {
			System.out.println("---Pandita's Pizza---");
			System.out.println("[1] Order Pizza");
			System.out.println("[2] View Order");
			System.out.println("[3] Cancel Order");
			System.out.println("[4] Total orders");
			System.out.println("[5] Save Receipt");
			System.out.println("[6] Exit");
			System.out.print("Your choice: ");
	}
	
	@Override
	public String toString() {
		return String.format("Size: %s Type: %s with %s | Price: %.2f",  size, type, toppings, price);
	}
}
