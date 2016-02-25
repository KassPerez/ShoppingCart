/*Kassandra Perez
 *EID: kap2589
 *
 *Rohan Tanna
 *EID: rrt494
 *
 *EE422C-Assignment 3
 */

package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ShoppingCartDriver 
{
	public static void main(String[] args) 
	{
		//Open file; file name specified in args (command line)
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		try 
		{
			FileReader freader = new FileReader(args[0]);
			BufferedReader reader = new BufferedReader(freader);
			
			//Stub for arraylist.
			ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
			
			//Parse input, take appropriate actions.
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				Transaction input = new Transaction(s);
				
				if(!input.invalidInput)
				{
					input.processTransaction(shoppingCart);
				}
				else
				{
					System.err.println("Invalid Input: " + "" + s + "");
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
