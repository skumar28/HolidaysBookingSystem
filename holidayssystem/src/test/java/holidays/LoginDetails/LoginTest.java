package holidays.LoginDetails;

import java.util.HashMap;
import java.util.Scanner;

import holidays.customer.LoginInfo;
import junit.framework.TestCase;

public class LoginTest {

	public static void main(String[] args) {

		try {
			// TODO Auto-generated method stub
			Login login = new Login();
			LoginInfo userInfo = new LoginInfo();

			HashMap<String, String> hm = new HashMap<String, String>();

			Scanner userInput = new Scanner(System.in);
			int choice;
			Boolean check;

			do {
				// display our menu
				System.out.println("\t\t\t*****Holiday Package Managment System*****\t\t\t");
				System.out.println("1. Sign In");
				System.out.println("2. Sign Up");
				System.out.println("3. Exit");
				System.out.println("**********************");
				System.out.println("\n\nPlease Enter Your Choice:");

				// get user input
				choice = userInput.nextInt();

				// switch the choice from user
				switch (choice) {
				case 1:
					// Sign In
					System.out.println("Enter UserName: ");
					userInfo.setUserName(userInput.next());
					System.out.println("Enter Passowrd");
					userInfo.setPassword(userInput.next());

					check = login.validateUser(userInfo);
					if (check == false) {
						System.out.println("Invalid Username or Password");
					} else {
						System.out.println("You have successfully loged in");
					}

					break;

				case 2:
					// Sign Up
					System.out.println("Enter UserName: ");
					userInfo.setUserName(userInput.next());
					System.out.println("Enter Password");
					userInfo.setPassword(userInput.next());

					check = login.registerNewUser(userInfo);
					if (check == false) {
						System.out.println("Username already in use!\nTry a new Username");
					} else {
						System.out.println("New User successfully created!");
					}

					break;
				case 3:

					System.out.println("You have exited successfully!");
					break;

				default:

					System.out.println("You entered an invalid choice");
				}

			} while (choice != 3);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
