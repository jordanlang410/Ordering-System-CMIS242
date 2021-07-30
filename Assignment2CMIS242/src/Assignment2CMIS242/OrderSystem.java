/* Name: Lang, Jordan
 * Date: 01/30/2021
 * Course/Section: CMIS 242/6380
*/
package Assignment2CMIS242;

import java.util.Scanner;

public class OrderSystem {

	static Gift gBasket = null;

	public static void main(String[] args) {

		Scanner keyboardInput = new Scanner(System.in);
		int userSelection;
			try {

				do {

					DisplayMenu();

					userSelection = keyboardInput.nextInt();

					switch (userSelection) {

					case 1:
						OrderGift();
						break;

					case 2:
						ChangeGift();
						break;

					case 3:
						Display();
						break;

					case 9:
						System.out.println("Thank you for using the program. GoodBye!");
						break;

					default:
						System.out.println("Please choose a number from the MENU.\n");

					}

				} while (userSelection != 9);

			} catch (Exception e) {
				System.out.println("Please choose a number from the MENU.");
			
		}
	}
	
	//create a method to display the users menu options each time
	public static void DisplayMenu() {
		System.out.println("      MENU");
		System.out.println("1: Order a Gift Basket");
		System.out.println("2: Change Gift Basket");
		System.out.println("3: Display Gift");
		System.out.println("9: Exit program");
	}

	public static void OrderGift() {

		Scanner keyboardInput = new Scanner(System.in);
		
		//initialize variables
		double basketPrice = 0.0;
		int numFruit = 0;
		boolean addCitrus = false;
		boolean addNuts = false;
		int basketType = 0;
		char basketSize = 0;
		int count = 0;

		//loop back if the user already ordered a gift
		if (gBasket != null) {

			System.out.println("You have already ordered a gift, please use option 2 to change its attributes.");
			return;
		}

		//use a while loop to ensure the loop continues until the user puts in a valid entry
		while (basketType != 1 && basketType != 2) {
			count++;
			if (count > 1) {//increase count so that error message will display after the first
							//loop if user enters an invalid entry
				
				System.out.println("\nThat is not a valid entry, please try again.\n");
			}
			try {
				System.out.println("Do you want Fruit Basket (1) or Sweets Basket (2): ");
				basketType = keyboardInput.nextInt();

			} catch (Exception e) {
				keyboardInput.next();
			}
		}

		//use a while loop to ensure the loop continues until the user puts in a valid entry
		while (basketSize != 'S' && basketSize != 's' && basketSize != 'M' && basketSize != 'm' && basketSize != 'L'
				&& basketSize != 'l') {

			System.out.println("What size do you want: S, M, or L: ");
			basketSize = keyboardInput.next().charAt(0);
			//small baskets are 19.99 with 6 fruits
			if (basketSize == 'S' || basketSize == 's') {
				basketPrice = 19.99;
				numFruit = 6;
			}
				
			//medium baskets are 29.99 with 9 fruits
			else if (basketSize == 'M' || basketSize == 'm') {
				basketPrice = 29.99;
				numFruit = 9;

			}

			//large baskets are 39.99 with 15 fruits
			else if (basketSize == 'L' || basketSize == 'l') {
				basketPrice = 39.99;
				numFruit = 15;

			}

			//loop back if user puts in an invalid entry
			else
				System.out.println("That is not a valid entry, please try again.\n");
		}

		// ask if the customer wants citrus fruits if they choose the fruit basket
		if (basketType == 1) {
			while (addCitrus != true || addCitrus != false) {
				try {
					System.out.println("Do you want citrus fruits included? true/false: ");
					addCitrus = keyboardInput.nextBoolean();
					if (addCitrus == true) {
						basketPrice += 5.99;//add 5.99 to the price if the user chooses to add citrus fruits
						break;
					} else if (addCitrus == false)
						break;

				} catch (Exception e) {
					System.out.println("\nThat is not a valid entry, please try again.\n");
					keyboardInput.next();
				}
			}
			gBasket = new FruitBasket("FB3150", basketSize, basketPrice, numFruit, addCitrus);
		}

		// ask if the customer wants nuts if they choose a sweets basket
		else if (basketType == 2) {

			while (addNuts != true || addNuts != false) {
				try {

					System.out.println("Do you want nuts included? true/false: ");
					addNuts = keyboardInput.nextBoolean();
					break;

				} catch (Exception e) {
					System.out.println("\nThat is not a valid entry, please try again.\n");
					keyboardInput.next();
				}
			}

			gBasket = new SweetsBasket("FB3150", basketSize, basketPrice, addNuts);

		}
	}

	public static void ChangeGift() {

		Scanner keyboardInput = new Scanner(System.in);

		//initialize variables
		char basketSize = 0;
		double basketPrice = 0.0;
		int numFruit = 0;
		boolean addCitrus = false;
		boolean addNuts = false;

		//loop back to the menu if the user has not put in an order to change yet
		if (gBasket == null) {
			System.out.println("\nYou have not ordered a gift yet. \n");
			return;
		}

		System.out.println("You're current gift size is: " + gBasket.getSize());
		
		//use a while loop to ensure the loop continues until the user puts in a valid entry
		while (basketSize != 'S' && basketSize != 's' && basketSize != 'M' && basketSize != 'm' && basketSize != 'L'
				&& basketSize != 'l') {

			System.out.println("What size do you want: S, M, or L: ");
			basketSize = keyboardInput.next().charAt(0);

			//small baskets are 19.99 with 6 fruits
			if (basketSize == 'S' || basketSize == 's') {
				basketPrice = 19.99;
				numFruit = 6;
			}

			//medium baskets are 29.99 with 9 fruits
			else if (basketSize == 'M' || basketSize == 'm') {
				basketPrice = 29.99;
				numFruit = 9;

			}

			//large baskets are 39.99 with 15 fruits
			else if (basketSize == 'L' || basketSize == 'l') {
				basketPrice = 39.99;
				numFruit = 15;

			}

			else
				System.out.println("That is not a valid entry, please try again.\n");
		}

		if (gBasket instanceof FruitBasket) {//check if user ordered a SweetsBasket or FruitsBasket
			System.out.println("Current basket citrus = " + ((FruitBasket) gBasket).getCitrus());

			//use a while loop to ensure the loop continues until the user puts in a valid entry
			while (addCitrus != true || addCitrus != false) {
				try {
					System.out.println("Do you want citrus fruits included? true/false: ");
					addCitrus = keyboardInput.nextBoolean();
					if (addCitrus == true) {
						basketPrice += 5.99;//add 5.99 to the price if the user chooses to add citrus fruits
						break;
					} else if (addCitrus == false)
						break;

				} catch (Exception e) {
					System.out.println("\nThat is not a valid entry, please try again.\n");
					keyboardInput.next();
				}
			}
			gBasket = new FruitBasket("FB3150", basketSize, basketPrice, numFruit, addCitrus);
		}

		if (gBasket instanceof SweetsBasket) {//check if user ordered a SweetsBasket or FruitsBasket
			System.out.println("Current basket nuts = " + ((SweetsBasket) gBasket).getNuts());

			while (addNuts != true || addNuts != false) {
				try {

					System.out.println("Do you want nuts included? true/false: ");
					addNuts = keyboardInput.nextBoolean();
					break;

				} catch (Exception e) {
					System.out.println("\nThat is not a valid entry, please try again.\n");
					keyboardInput.next();
				}
			}
			gBasket = new SweetsBasket("FB3150", basketSize, basketPrice, addNuts);
		}

	}

	public static void Display() {
		//loop back to the display menu if the user has not ordered a gift yet
		if (gBasket == null) {
			System.out.println("You have not ordered a gift yet.\n");
		}

		else
			System.out.println(gBasket);//display the gift the user ordered

	}
}
