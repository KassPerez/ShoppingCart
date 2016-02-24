/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 2
 */

package Assignment3;

//clothing item
//always standard shipping
//always 10% sales tax
//no extra properties
public class Clothing extends Item 
{

	// variables, constructors as necessary
	public Clothing(String givenName, float givenPrice, int givenQuantity, int givenWeight){
		super(givenName, givenPrice, givenQuantity, givenWeight);
	}
	
	float calculatePrice () 
	{
		float final_price = super.calculatePrice();
		// Insert price calculation here
		final_price = (float) (1.1 * final_price); //account for sales tax
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
		super.printItemAttributes();
	}
	

}
