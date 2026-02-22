package practice2;

public class OrderSystem {
	//enum for pizza size
	public enum PizzaSize {
		SMALL,
		MEDIUM,
		LARGE
	}
	
	//enum for pizza type
	public enum PizzaType {
		PEPPERONI,
		CHEESY,
		PINEAPPLE
	}
	//fields
	PizzaSize size;
	PizzaType type;
	
	//constructor
	public OrderSystem(PizzaSize size, PizzaType type) {
		this.size = size;
		this.type = type;
	}
	
	public String toString() {
		return size + " | " + type;
	}
}
