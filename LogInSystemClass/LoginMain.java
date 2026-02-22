package practice2;
import java.util.*;

import practice2.User.Role; // import the Role enum from User class
public class LogInSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner for reading user input
		List<User> users = new ArrayList<>(); // List to store all users
		users.add(new User("Jal", "passAdmin", Role.ADMIN)); // create an initial admin account
		
		String choice; // to store user menu choice
		boolean adminLogin = true; // flag for admin menu loop
		
			do{
				//Main menu
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.print("Your Choice: ");
				choice = sc.nextLine().trim();
				switch(choice) {
				
				case "1":  // REGISTER NEW USER
					System.out.print("Enter Username: ");
					String u = sc.nextLine().trim();
					
					System.out.print("Enter Password: ");
					String p = sc.nextLine().trim();
					
					// create new User object and add to users list
					User addUser = new User(u,p, true); // true = email verified
					users.add(addUser);
					System.out.println("Account Created!");
					break;
				case "2": // LOGIN
					System.out.print("Username: ");
					String lu = sc.nextLine().trim();
					
					System.out.print("Password: ");
					String lp = sc.nextLine().trim();
					
					User found = null; // will store the logged-in user
					
					// search for the user in the list
					for(User user : users) {
						if(user.getUsername().equals(lu)) {
							found = user;
							break;
						}
					}
					
					if(found == null) { // search for the user in the list	
						System.out.println("User not found!");
						break;
					}
					
					if(found.checkPassword(lp)) { // password correct
						System.out.println("Login Successfully!");
						if(found.getRole() == Role.ADMIN) { // admin login
							System.out.println("Welcome Admin!");
							
							//ADMIN MENU LOOP
							while(adminLogin) {
							System.out.println("---ADMIN MENU---");
							System.out.println("[1] View all users");
							System.out.println("[2] Suspend a user");
							System.out.println("[3] Ban a user");
							System.out.println("[4] Logout");
							System.out.print("Your choice: ");
							String adminChoice = sc.nextLine();
							
							switch(adminChoice) {
							case "1": // VIEW ALL USERS
								if(users.isEmpty()) {
									System.out.println("No Users!");
								}else {
									for(User user : users) {
										System.out.println(user); // calls overridden toString()
									}
								}
								break;
							case "2": // SUSPEND A USER
								System.out.print("Enter a username to suspend: ");
								String targetUsername = sc.nextLine();
								
								 // find the target user
								User targetUser = null;
								for(User user : users) {
									if(user.getUsername().equals(targetUsername)) {
										targetUser = user;
									}
								}
								
								if(targetUser == null) {
									System.out.println("Username not found!");
									break;
								}else if(targetUser.getRole() == Role.ADMIN) {
									System.out.println("You cant ban or suspend and admin!");
								}else if (targetUser.getUsername().equals(found.getUsername())){
									System.out.println("You can't ban or suspend yourself!");
								}else { // set account status to SUSPENDED
									targetUser.suspend();
									System.out.println(targetUsername + " is now suspended!");
									break;
								}
							case "3": // BAN USER (you can implement same as suspend)
								// similar logic: check role, check self, then call targetUser.ban()
								break;
								
							case"4":
								System.out.println("Exiting. . ");
								adminLogin = false; // break out of admin menu loop
								break;
								
							}
							}  // end admin menu loop
						}else {// normal user login
							System.out.println("Welcome User!");
						}
					}else { // wrong password
						System.out.println("Wrong password!");
					}
					break;
					
				case "3": // EXIT
					System.out.println("Exiting."); 
					break;
					default:
						System.out.println("Invalid choice");
						return;
				}
		}while(!choice.equals("3")); // repeat until user chooses exit
			sc.close();
	}
}
