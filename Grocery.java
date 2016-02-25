/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 3
 */

package Assignment3;

//grocery item
//no sales tax
//if perishable, must use premium shipping 

public class Grocery extends Item {
	//variables, constructor here
	boolean perishable;
	
	public Grocery(String givenName, float givenPrice, int givenQuantity, int givenWeight, boolean givenPerishable){
		super(givenName, givenPrice, givenQuantity, givenWeight);
		perishable = givenPerishable;
	}
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	float calculatePrice(){
		float final_price = super.calculatePrice(); //accounts for shipping
		if (perishable){ //must account for premium shipping if perishable
			final_price = (float) (final_price + .2*((20 * weight)* quantity));
		}
		
		
		
		return final_price;
	}
	
	void printItemAttributes(){
		String perishability;
		if (perishable){
			perishability = "perishable";
		}
		else{
			perishability = "not perishable";
		}
		
		System.out.println("Item name: " + name + ". Item Price: $" + String.format("%.2f",price)+ ". Total Price: $" + String.format("%.2f",calculatePrice()) + ". Item Quantity: " + quantity + ". Weight is: " + weight + ". The item is "
				+ perishability);

	}
	
}