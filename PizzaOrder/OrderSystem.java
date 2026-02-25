package practice2;
import java.lang.IllegalArgumentException; 

public class OrderSystem {
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
	Toppings top;
	private double price; 
	
	//constructor
	public OrderSystem(PizzaSize size, PizzaType type, Toppings top) {
		this.size = size;
		this.type = type;
		this.top = top;
	}
	
	//getter
	public double getPriceForPizza() {
		switch(size) {
		case SMALL: price += 45.2; break;
		case MEDIUM: price += 49.3; break;
		case LARGE: price += 54.5; break;
		case XLARGE: price += 60.22; break;	
		default:
			throw new IllegalArgumentException("Invalid!");
		}
		
		switch(type) {
		case PEPPERONI: price += 55.3; break;
		case CHEESY: price += 61.1; break;
		case HAWAIIAN: price += 66.2; break;
		case NEAPOLITAN: price += 70.7; break;
		default:
			throw new IllegalArgumentException("Invalid!");
		}
		
		switch(top) {
		case BACON: price += 32.2; break;
		case OLIVES: price += 29.4; break;
		case SAUSAGE: price += 39.11; break;
		case ONIONS: price += 28.65; break;
		case NONE: price += 0.0; break;
		default:
			throw new IllegalArgumentException("Invalid!");
		}
		return price;
	}
	
	public static void Menu() {
			System.out.println("---Pandita's Pizza---");
			System.out.println("[1] Order Pizza");
			System.out.println("[2] View Order");
			System.out.println("[3] Cancel Order");
			System.out.println("[4] Exit");
			System.out.print("Your choice: ");
	}
	
	public String toString() {
		return  "Size: " + size + " | Type: " + type + " with " + top + " | Price: " + price;
	}
}
