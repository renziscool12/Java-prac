package practice2;
import java.lang.IllegalArgumentException;
public class User {
	//ENUMS
	public enum Role {
		USER,
		ADMIN
	}
	
	public enum AccountStatus {
		ACTIVE,
		SUSPENDED,
		BANNED
	}
	
	//FIELDS
	private String username;
	private String password;
	private Role role;
	private AccountStatus accountstatus;
	private boolean emailVerified;
	
	//Constructor for normal users
	public User(String username, String password, boolean emailVerified) {
		this.username = username;
		// password validation
		if(password.length() < 4) {
			throw new IllegalArgumentException("Password too short! Min 4 characters.");
		}else if (password.length() > 10) {
			throw new IllegalArgumentException("Password too long! Max 10 characters.");
		}
		
		this.password = password;
		
		this.role = Role.USER; // default role
		this.accountstatus = AccountStatus.ACTIVE; // default status
		this.emailVerified = emailVerified;
	}
	
	//CONSTRUCTOR FOR ADMIN USER
	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role; //usually admin
		this.accountstatus = AccountStatus.ACTIVE;
		this.emailVerified = true; // admin email auto verified
	}
	
	//Getters
	public String getUsername() {return username;}
	public Role getRole() { return role; }
	public AccountStatus getAccountStatus() { return accountstatus; }
	public boolean getEmailVerified() { return emailVerified; }
	
	//CHECKS PASSWORD
	public boolean checkPassword(String input) {
		return this.password.equals(input);
	}
	
	//CHANGE PASSWORD
	public boolean changePassword(String oldPassword, String newPassword)
	{
		if(!this.password.equals(oldPassword)) {
			System.out.println("Old Password incorrect!");
			return false;
		}else if(newPassword.length() < 4) {
			System.out.println("New password too short! Min 4 Characters");
			return false;
		}else if(newPassword.length() > 10) {
			System.out.println("New password too long! Min 10 Charaters");
			return false;
		}
		this.password = newPassword;
		return true;
	}
	
	//ACCOUNT STATUS METHODS
	public void suspend() { accountstatus = AccountStatus.SUSPENDED; }
	public void ban() { accountstatus = AccountStatus.BANNED; }
	public void active() { accountstatus = AccountStatus.ACTIVE; }
	
	//EMAIL VERIFICATION
	public void verifyEmail() { emailVerified = true; }
	
	//CHECK IF YOU CAN LOGIN
	public boolean canLogin() {
			if(accountstatus == AccountStatus.BANNED) {
				System.out.println("Your Account is Banned!");
				return false;
			}
			
			if(accountstatus == AccountStatus.SUSPENDED) {
				System.out.println("Your Account is Suspended!");
				return false;
			}
			return true; //account active
	}
	
	//override string for printing
	public String toString() {
		return "Username: " + username + " | Role: " + role + " | Status: " + accountstatus + " | Email Verified: " + emailVerified;
		// NOTE: password is intentionally excluded for security
	}
}
