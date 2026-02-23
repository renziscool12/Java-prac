package practice2;
import java.util.*;
import java.lang.IllegalArgumentException; 
import practice2.OrderSystem.PizzaType; //call our enum for pizza type
import practice2.OrderSystem.PizzaSize; //call our enum for pizza size
public class PizzaOrderingSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner to read input
		List<OrderSystem> order = new ArrayList<>(); //array list so we can add the orders
		boolean isRunning = true; //bool flag for the main menu loop
		System.out.println("Current Orders: " + order);  // shows orders at the start (empty
		
		//menu
		while(isRunning) {
			System.out.println("[1] Order Pizza");
			System.out.println("[2] View Order");
			System.out.println("[3] Cancel Order");
			System.out.println("[4] Exit");
			System.out.print("Your choice: ");
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
		
		System.out.println("Choose the size of the pizza(SMALL, MEDIUM, LARGE)"); // Ask the user which size of pizza they want
		try { //try if you picked something then it adds to array list named order
			size = PizzaSize.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) { // catch for when wrong input it automatically pick Small
			System.out.println("Invalid type, defaulting	 to SMALL");
			size = PizzaSize.SMALL;
		}
		
		System.out.println("Choose your pizza(PEPPERONI, CHEESY, PINEAPPLE"); // // Ask the user which type of pizza they want
		try { //try if you picked something then it adds to array list named order
			type = PizzaType.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) {  // catch for when wrong input it automatically pick Pepperoni
			System.out.println("Invalid type, defaulting	 to PEPPERONI");
			type = PizzaType.PEPPERONI;
		}
		
		//then it add to our new ordersystem
		order.add(new OrderSystem(size, type));
		System.out.println("Order added: " + type + " " + size);
	}
	
	//checks if we order something or not
	public static void viewOrders(List<OrderSystem> order) {
		if(order.isEmpty()) {
			System.out.println("You didn't ordered!");
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
