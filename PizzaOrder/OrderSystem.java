package practice2;

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
		HAWAIIAN
	}
	//fields
	PizzaSize size;
	PizzaType type;
	private double price; 
	
	//constructor
	public OrderSystem(PizzaSize size, PizzaType type) {
		this.size = size;
		this.type = type;
	
	}
	
	//getter
	public double getPrice() { return price; }
	
	public double getPriceForPizza() {
		switch(type) {
		case PEPPERONI:
			switch(size) {
			case SMALL:
				return 110.09;
			case MEDIUM:
				return 115.2;
			case LARGE:
				return 120.72;
			case XLARGE:
				return 130.12;
				default:
					System.out.println("Unexpected Pizza!");
					return price;
			}
		case CHEESY:
			switch(size) {
			case SMALL:
				return 130.11;
			case MEDIUM:
				return 135.32;
			case LARGE:
				return 140.21;
			case XLARGE:
				return 150;
				default:
					System.out.println("Unexpected Pizza!");
					return price;
			}
		case HAWAIIAN:
			switch(size) {
			case SMALL:
				return 155.89;
			case MEDIUM:
				return 165.22;
			case LARGE:
				return 170.32;
			case XLARGE:
				return 175.55;
				default:
					System.out.println("Unexpected Pizza!");
					return price;
			}
			default:
				System.out.println("Unexpected Pizza!");
				return price;
		}	
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
		return  "Size: " + size + " | Type: " + type + " | Price: " + price;
	}
}
