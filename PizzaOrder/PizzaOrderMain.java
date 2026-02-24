package practice2;
import java.util.*;
import java.lang.IllegalArgumentException; 
import practice2.OrderSystem.PizzaType; //call our enum for pizza type
import practice2.OrderSystem.PizzaSize; //call our enum for pizza size
import practice2.OrderSystem.Toppings;
public class PizzaOrderingSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner to read input
		List<OrderSystem> order = new ArrayList<>(); //add all pizza here
		boolean isRunning = true; //bool flag for the main menu loop
	
		//menu
		while(isRunning) {
			OrderSystem.Menu();
			String choice = sc.nextLine();
			
			//choices
			switch(choice) {
			case "1":
				orderPizza(sc,order);
				
				break;
			case "2":
				viewOrders(order);
				break;
			case "3":
				cancelOrder(order, sc);
				break;
			case "4":
				System.out.println("Exiting. . .");
				isRunning = false;
				sc.close();
			}
		}
	}
	//method
	public static void orderPizza(Scanner sc, List<OrderSystem> order) {
		PizzaType type; //call pizza type
		PizzaSize size; //call pizza size
		Toppings top;
		int i = 1;
		int j = 2;
		
		System.out.println("Choose pizza size(WORDS ONLY)");// Ask the user which size of pizza they want
		for(PizzaSize s : PizzaSize.values()) {
			System.out.println(i + ". " + s);
			i++;
		}
		try { //try if you picked something then it adds to array list named order
			size = PizzaSize.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) { // catch for when wrong input it automatically pick Small
			System.out.println("Invalid type, defaulting	to SMALL");
			size = PizzaSize.SMALL;
		}
		
		System.out.println("Choose your pizza(WORDS ONLY)"); // Ask the user which type of pizza they want
		for(PizzaType t : PizzaType.values()) {
			System.out.println(j + ". " + t);
			j++;
		}
		try { //try if you picked something then it adds to array list named order
			type = PizzaType.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) {  // catch for when wrong input it automatically pick Pepperoni
			System.out.println("Invalid type, defaulting	 to PEPPERONI");
			type = PizzaType.PEPPERONI;
		}
		
		System.out.println("Choose your toppings(WORDS ONLY)");
		for(Toppings t : Toppings.values()) {
			System.out.println(t);
		}
		try {
			top = Toppings.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid type, No toppings");
			top = Toppings.NONE; //initialize this when you use enum valueof
		}
		  
		//then it add to our new orders system
		//chekcs the price
		OrderSystem pizza = new OrderSystem(size, type, top);
		order.add(pizza);
		System.out.println("Order added: " + type + " " + size);
		System.out.printf("Price: %.2f", pizza.getPriceForPizza());
		
	}
	
	//checks if we order something or not
	public static void viewOrders(List<OrderSystem> order) {
		if(order.isEmpty()) {
			System.out.println("You didn't ordered anything!");
		}else {
			for(OrderSystem orders : order) {
				System.out.println(orders);
			}
		}
	}
	//cancels order
	public static void cancelOrder(List <OrderSystem> order, Scanner sc) {
		if(order.isEmpty()) {
			System.out.println("No pizza to cancel!");
		}else {
			for(OrderSystem orders : order) {
				System.out.println(orders);
			}
			System.out.println("Choose a pizza to cancel");
			int cancelPizza = Integer.parseInt(sc.nextLine()) - 1;
			
			if(cancelPizza >= 0 && cancelPizza < order.size()) {
				order.remove(cancelPizza);
				System.out.println("Successfully Canceled!");
			}else {
				System.out.println("Invalid!");
			}
		}
	}
}
