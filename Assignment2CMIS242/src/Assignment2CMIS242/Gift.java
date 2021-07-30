/* Name: Lang, Jordan
 * Date: 01/30/2021
 * Course/Section: CMIS 242/6380
*/
package Assignment2CMIS242;

public class Gift {
	
	private String id;
	private char size;
	private double price;
	
	public Gift(String id, char size, double price) {
		
		this.id = id;
		this.size = size;
		this.price = price;
		
	}
	
	//Getter methods
	public String getId() {
		return id;
	}
	
	public char getSize() {
		return size;
	}
	
	public double getPrice() {
		return price;
	}
	
	//Setter methods
	public void setId(String id) {
		this.id = id;
	}
	
	public void setSize(char size) {
		this.size = size;
	}
	
	public void setPrice(double price) {
		this.price = price;
		
	}
}
 