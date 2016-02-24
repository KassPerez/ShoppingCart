/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 2
 */

package Assignment3;

public class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?
	String name;
	float price;
	int quantity;
	int weight;
	//boolean premiumShipping;

// You will need a constructor (Why?). Create it here.
	
	public Item(String givenName, float givenPrice, int givenQuantity, int givenWeight){
		name = givenName;
		price = givenPrice;
		quantity = givenQuantity;
		weight = givenWeight;
	}
	
	float calculatePrice () //item parent class will only calculate extra shipping cost, since that is applied to all subclasses 
	{
		float final_price = price + (20 * weight)*quantity;
		// Insert price calculation here
		return final_price;
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
		System.out.println("Item name: " + name + ". Item Price: $" + String.format("%.2f",price)+ ". Total Price: $" + String.format("%.2f",calculatePrice()) + ". Item Quantity: " + quantity + ". Weight is: " + weight + ".");
	}

}