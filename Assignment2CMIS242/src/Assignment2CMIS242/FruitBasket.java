/* Name: Lang, Jordan
 * Date: 01/30/2021
 * Course/Section: CMIS 242/6380
*/
package Assignment2CMIS242;

public class FruitBasket extends Gift {

	private int numOfFruit;
	private boolean citrus;

	public FruitBasket(String id, char size, double price, int numOfFruit, boolean citrus) {
		super(id, size, price); //use variables from Gift class

		this.numOfFruit = numOfFruit;
		this.citrus = citrus;

	}

	//Getter methods
	public int getNumOfFruit() {
		return numOfFruit;
	}

	public boolean getCitrus() {
		return citrus;
	}

	//Setter methods
	public void setNumOfFruit(int numOfFruit) {
		this.numOfFruit = numOfFruit;
	}

	public void setCitrus(boolean citrus) {
		this.citrus = citrus;
	}

	//use toString methods to return string representation of an object
	@Override
	public String toString() {

		return "FruitBasket [numFruit = " + getNumOfFruit() + ", haveCitrus = " + getCitrus() + ", size = " + getSize() + ", id = "
				+ getId() + ", price = " + String.format("%.4g", getPrice()) + "]\n";

	}
}
