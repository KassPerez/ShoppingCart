/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 2
 */

package Assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class Transaction 
{
	// attributes
	protected String operation;
	protected String category;
	protected String name;
	protected float price;
	protected int quantity;
	protected int weight;
	protected String optionalField1;
	protected String optionalField2;
	protected boolean invalidInput;
	
	// constructor 
	public Transaction(String input)
	{
		try
		{
			input = input.trim();
			String[] temp = input.split(" ");
			invalidInput = false;
			operation = temp[0].toLowerCase();
			if(!isOperation(operation))
			{
				invalidInput = true;
			}
			switch(operation)
			{
				case("print"):
					if(temp.length > 1)
					{
						invalidInput = true;
					}
					break;
				
				case("update"):
					if(temp.length > 3)
					{
						invalidInput = true;
					}
					else
					{
						name = temp[1];
						quantity = Integer.parseInt(temp[2]);
						if(quantity < 0)
						{
							invalidInput = true;
						}
					}					
					break;
					
				case("delete"):
					if(temp.length > 2)
					{
						invalidInput = true;
					}
					else
					{
						name = temp[1];
					}
					break;
				
				case("search"):
					if(temp.length > 2)
					{
						invalidInput = true;
					}
					else
					{
						name = temp[1];
					}
					break;
				
				case("insert"):
					if(!temp[1].isEmpty())
					{
						category = temp[1].toLowerCase();
						if(!isCategory(category))
						{
							invalidInput = true;
						}
						switch(category)
						{
							case("electronics"):
								if(temp.length > 8)
								{
									invalidInput = true;
								}
								else
								{
									name = temp[2];
									price = Float.parseFloat(temp[3]);
									if(price < 0)
									{
										invalidInput = true;
									}
									float tempQuantity =  Float.parseFloat(temp[4]);
									quantity = (int) tempQuantity;
									if(quantity < 0)
									{
										invalidInput = true;
									}
									float tempWeight =  Float.parseFloat(temp[5]);
									weight = (int) tempWeight;
									if(weight < 0)
									{
										invalidInput = true;
									}
									optionalField1 = temp[6].toUpperCase();
									if(!optionalField1.equals("F") && !optionalField1.equals("NF"))
									{
										invalidInput = true;
									}
									optionalField2 = temp[7].toUpperCase();
									if(!isState(optionalField2))
									{
										invalidInput = true;
									}
								}
								break;
							case("groceries"):
								if(temp.length > 7)
								{
									invalidInput = true;
								}
								else
								{
									name = temp[2];
									price = Float.parseFloat(temp[3]);
									if(price < 0)
									{
										invalidInput = true;
									}
									float tempQuantity =  Float.parseFloat(temp[4]);
									quantity = (int) tempQuantity;
									if(quantity < 0)
									{
										invalidInput = true;
									}
									float tempWeight =  Float.parseFloat(temp[5]);
									weight = (int) tempWeight;
									if(weight < 0)
									{
										invalidInput = true;
									}
									optionalField1 = temp[6].toUpperCase();
									if(!optionalField1.equals("P") && !optionalField1.equals("NP"))
									{
										invalidInput = true;
									}
								}
								break;
							case("clothing"):
								if(temp.length > 6)
								{
									invalidInput = true;
								}
								else
								{
									name = temp[2];
									price = Float.parseFloat(temp[3]);
									if(price < 0)
									{
										invalidInput = true;
									}
									float tempQuantity =  Float.parseFloat(temp[4]);
									quantity = (int) tempQuantity;
									if(quantity < 0)
									{
										invalidInput = true;
									}
									float tempWeight =  Float.parseFloat(temp[5]);
									weight = (int) tempWeight;
									if(weight < 0)
									{
										invalidInput = true;
									}
								}
								
								break;
						}
					}
					else
					{
						invalidInput = true;
					}
					break;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			invalidInput = true;
		}
	}
	
	public boolean isState(String state)
	{
		String[] stateNames = { "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU",
				"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
				"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC",
				"SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", "WV", "WI", "WY", "AE", "AA", "AP" };
		for(int i = 0;i < stateNames.length;i++)
		{
			if(stateNames[i].equals(state))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isCategory(String category)
	{
		switch(category)
		{
			case("groceries"):
				return true;
			case("electronics"):
				return true;
			case("clothing"):
				return true;
			default:
				return false;
		}
	}
	
	public boolean isOperation(String operation)
	{
		switch(operation)
		{
			case("insert"):
				return true;
			case("search"):
				return true;
			case("delete"):
				return true;
			case("update"):
				return true;
			case("print"):
				return true;
			default:
				return false;
		}
	}

	public void processTransaction(ArrayList<Item> shoppingCart)
	{
		switch(operation)
		{
			case("insert"):
				processInsert(shoppingCart);
				break;
			case("search"):
				System.out.println(" - Search: ");
				processSearch(shoppingCart);
				break;
			case("delete"):
				System.out.println(" - Delete: ");
				processDelete(shoppingCart);
				break;
			case("update"):
				System.out.println(" - Update: ");
				processUpdate(shoppingCart);
				break;
			case("print"):
				System.out.println(" - Print: ");
				processPrint(shoppingCart);
				break;
		}
	}

	public void processInsert(ArrayList<Item> shoppingCart)
	{
		switch(category)
		{
			case("clothing"):
				Clothing clothTemp = new Clothing(name,price,quantity,weight);
				shoppingCart.add(clothTemp);
				break;
			case("electronics"):
				boolean fragile = false;
				if(optionalField1.equals("F"))
				{
					fragile = true;
				}
				Electronics electTemp = new Electronics(name,price,quantity,weight,fragile,optionalField2);
				shoppingCart.add(electTemp);
				break;
			case("groceries"):
				boolean perishable = false;
				if(optionalField1.equals("P"))
				{
					perishable = true;
				}
				Grocery grocTemp = new Grocery(name,price,quantity,weight,perishable);
				shoppingCart.add(grocTemp);
				break;
		}
		shoppingCart.sort((item1,item2) -> item1.name.compareTo(item2.name));
	}	
	
	public void processDelete(ArrayList<Item> shoppingCart)
	{
		int numOfItems = 0;
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			if(temp.name.equals(name))
			{
				numOfItems += 1;
				shoppingCart.remove(temp);
				i = shoppingCart.iterator();
			}
		}
		System.out.println("There were " + numOfItems + " " + name + " deleted.");
	}
	
	public void processSearch(ArrayList<Item> shoppingCart)
	{
		int numOfItems = 0;
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			if(temp.name.equals(name))
			{
				numOfItems += 1;
			}
		}
		System.out.println("There are " + numOfItems + " " + name + " in the shopping cart.");
	}
	
	public void processUpdate(ArrayList<Item> shoppingCart)
	{
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			if(temp.name.equals(this.name))
			{
				temp.quantity = this.quantity;
				temp.printItemAttributes();
				return;
			}
		}
		
	}
	
	public void processPrint(ArrayList<Item> shoppingCart)
	{
		// iterate an array list.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.printItemAttributes();
		}
		System.out.println("The Total Price: $" + totalPrice(shoppingCart));
	}
	
	public float totalPrice(ArrayList<Item> shoppingCart)
	{
		float total = 0;
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			total += temp.calculatePrice();
		}
		return total;
	}
}