package practice2;
import java.util.*;
import java.lang.IllegalArgumentException; 
import practice2.Pizza.PizzaType; //call our enum for pizza type
import practice2.Pizza.PizzaSize; //call our enum for pizza size
import practice2.Pizza.Toppings;
public class PizzaOrderingSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner to read input
		List<Pizza> order = new ArrayList<>(); //add all pizza here
		boolean isRunning = true; //bool flag for the main menu loop
	
		//menu
		while(isRunning) {
			Pizza.Menu();
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
				totalPizza(order);
				break;
			case "5":
				System.out.println("Exiting. . .");
				isRunning = false;
				sc.close();
			}
		}
	}
	//method
	public static void orderPizza(Scanner sc, List<Pizza> Pizza) {
		PizzaType type; //call pizza type
		PizzaSize size; //call pizza size
		int quantity = 1;
		String again;
		
		
		do {
		System.out.println("Choose pizza size(WORDS ONLY)");// Ask the user which size of pizza they want
		for(PizzaSize s : PizzaSize.values()) {
			System.out.println( s);
		}
		try { //try if you picked something then it adds to array list named order
			size = PizzaSize.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) { // catch for when wrong input it automatically pick Small
			System.out.println("Invalid type, defaulting	to SMALL");
			size = PizzaSize.SMALL;
		}
		
		System.out.println("Choose your pizza(WORDS ONLY)"); // Ask the user which type of pizza they want
		for(PizzaType t : PizzaType.values()) {
			System.out.println(t);
		}
		try { //try if you picked something then it adds to array list named order
			type = PizzaType.valueOf(sc.nextLine().toUpperCase());
		}catch(IllegalArgumentException e) {  // catch for when wrong input it automatically pick Pepperoni
			System.out.println("Invalid type, defaulting	 to PEPPERONI");
			type = PizzaType.PEPPERONI;
		}
		
		//tells you what toppings are available
		System.out.println("Toppings available.");
		for(Toppings t : Toppings.values()) {
			System.out.println(t);
		}
		List<Toppings> selectToppings = new ArrayList<>();
		String input;
		
		while(true) { // while if you want multiple toppings
			System.out.println("Entter toppings you wish to put (e.g., BACON, OLIVES) Type 'done' to prooced");
			input = sc.nextLine().trim();
			
			if(input.equalsIgnoreCase("done"))	{ // if done it will proceed to the next line of code
				break;
			}
			
			for(String topp : input.split(",")) { // split for when you order multiple toppings like this Onions, sausage
				try {
					Toppings topping = Toppings.valueOf(topp.trim().toUpperCase());
					if(topping != Toppings.NONE) {
						selectToppings.add(topping);
					}
				}catch(IllegalArgumentException e ) {
					System.out.println(topp.trim() + " is invalid!");
				}
			}
		}
		System.out.print("How many? "); // quantity
		try {
			quantity = Integer.parseInt(sc.nextLine().trim());
			if(quantity <= 0) {
				System.out.println("Invalid, you get one");
				quantity = 1;
			}
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid input, you get one");
			quantity = 1;
		}
		
	
		Pizza pizza = new Pizza(size, type, selectToppings, quantity);
		Pizza.add(pizza);
		System.out.println("Order added: " + type + " " + size + " with " + selectToppings + " x " + quantity);
		System.out.printf("Price: ₱%.2f%n", pizza.getPriceForPizza());
	
		System.out.print("Do you want to order again? (YES/NO): ");
		again = sc.nextLine();
		}while(again.equalsIgnoreCase("yes"));
	}
	
	//checks if we order something or not
	public static void viewOrders(List<Pizza> pizza) {
		if(pizza.isEmpty()) {
			System.out.println("You didn't ordered anything!");
		}else {
			for(Pizza orders : pizza) {
				System.out.println(orders);
			}
		}
	}
	//cancels order
	public static void cancelOrder(List <Pizza> pizza, Scanner sc) {
		if(pizza.isEmpty()) {
			System.out.println("No pizza to cancel!");
		}else {
			for(Pizza orders : pizza) {
				System.out.println(orders);
			}
			System.out.println("Choose a pizza to cancel");
			int cancelPizza = Integer.parseInt(sc.nextLine()) - 1;
			
			if(cancelPizza >= 0 && cancelPizza < pizza.size()) {
				pizza.remove(cancelPizza);
				System.out.println("Successfully Canceled!");
			}else {
				System.out.println("Invalid!");
			}
		}
	}
	public static double totalPizza(List<Pizza> pizza) {
		double totalSum = 0;
		if(pizza.isEmpty()) {
			System.out.println("No order yet!");
		}else {
		for(Pizza e : pizza) {
			totalSum += e.getPriceForPizza();
		}
		System.out.printf("The toatl cost of the pizza is: ₱%.2f%n" + totalSum);
	}
		return totalSum;
	}
}
