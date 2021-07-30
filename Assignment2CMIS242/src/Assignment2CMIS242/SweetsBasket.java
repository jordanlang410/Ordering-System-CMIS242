/* Name: Lang, Jordan
 * Date: 01/30/2021
 * Course/Section: CMIS 242/6380
*/
package Assignment2CMIS242;

public class SweetsBasket extends Gift {

	private boolean nuts;

	public SweetsBasket(String id, char size, double price, boolean nuts) {
		super(id, size, price); //use variables from Gift class

		this.nuts = nuts;
	}

	//Getter method
	public boolean getNuts() {
		return nuts;
	}

	//Setter method
	public void setNusts(boolean nuts) {
		this.nuts = nuts;
	}

	//use toString methods to return string representation of an object
	@Override
	public String toString() {

		return "SweetsBasket [nuts = " + getNuts() + ", size = " + getSize() + ", id = " + getId() + ", price = " + getPrice() + "]";

	}
}
