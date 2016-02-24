/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 2
 */

package Assignment3;

//electronics class
//if fragile, premium shipping. else, regular shipping.
//if shipping to TX, NM, VA, AZ, AK: no sales tax

public class Electronics extends Item 
{
	boolean fragile;
	String State;
	
	// Variables, constructors etc. here.
	public Electronics(String givenName, float givenPrice, int givenQuantity, int givenWeight, boolean givenFragile, String givenState){
		super(givenName, givenPrice, givenQuantity, givenWeight);
		fragile = givenFragile;
		State = givenState.toUpperCase();
		
	}
	
	float calculatePrice(){
		float final_price = super.calculatePrice();// this accounts for regular shipping cost
		if (fragile){ //account for premium shipping
			final_price = (float) (final_price + .2*((20*weight)*quantity));
		}
		boolean salesTax = true;
		
		if ((State.equals("TX")) || (State.equals("NM")) || (State.equals("VA")) || (State.equals("AZ")) || (State.equals("AK"))){
			salesTax = false; //destination is not taxed 
		}
		
		if (salesTax){
			final_price = (float) (1.1 * final_price);	//account for sales tax 
		}
		
		
		return final_price;
	}

		void printItemAttributes(){
			String fragility;
			if (fragile){
				fragility = "fragile.";
			}
			else{
				fragility = "not fragile.";
			}
			System.out.println("Item name: " + name + ". Item Price: $" + String.format("%.2f",price)+ ". Total Price: $" + String.format("%.2f",calculatePrice()) + ". Item Quantity: " + quantity + ". Weight is: " + weight + ". The item is "
					+ fragility + " The destination is " + State + ".");

		}

}
