package view;

import java.util.HashMap;
import java.util.Scanner;

import message.message;
import model.Item;
import controller.CartController;

public class CartView 
{
	static Scanner sc =new Scanner(System.in);
	
	public static void main(String arg[])
	{
		int itemId=0,quantity=0;
		showItem();
		
			while(true)
			{
				try
				{
				System.out.println(message.OPTIONHEADER);
				System.out.println(message.SELECTOPTION);
				
					
				int option=sc.nextInt();
				switch(option)
				{
					case 1:
							
						System.out.println(message.ENTERID);
						itemId=sc.nextInt();
						System.out.println(message.ENTERQUANTITY);
						quantity=sc.nextInt();
						addItem(itemId, quantity);
						break;
						
					case 2:
						viewCart();
						break;
						
					case 3:
						System.out.println(message.ENTERIDEDIT);
						itemId=sc.nextInt();
						System.out.println(message.ENTERQUANTITY);
						break;
						
					case 4:
						System.out.println(message.ENTERIDREMOVE);
						itemId=sc.nextInt();
						removeItem(itemId);
						break;
						
					case 5:
						System.out.println(message.TOTALAMOUNT);
						double amount =generateBill();
						System.out.println(amount);
						break;
						
					case 6:
						System.out.println(message.THANKYOU);
						System.exit(0);
						break;
							
				}
				}
				catch(Exception e)
				{
					
					System.out.println(message.INVALIDOPTION);
					sc.nextLine();
					
				}
			
			
		
	}
		
		}
	
	/**
	 * shows all the available items
	 */
	public static void showItem()
	{
		HashMap<Integer,Item> products= CartController.allAvailableItemsController();
		System.out.println(message.SHOPPINGHEADER);
		for(HashMap.Entry<Integer,Item> entry:products.entrySet())
		{
			System.out.println(entry.getKey()+"\t \t"+entry.getValue().getName()+"\t \t"+entry.getValue().getPrice());
		}
	}
	/**
	 * views cart
	 */
	public static void viewCart()
	{
		HashMap<Integer,Item> userCart = CartController.getCartController();
		if(userCart.isEmpty())
		{
			System.out.println(message.EMPTYCART);
		}
		else
		{
			System.out.println(message.CARTHEADER);
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())  
			{
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity()); 
			}
		}
			
	}
	/**
	 * 
	 * @param id
	 * @param quantity
	 * adds item to the cart
	 */
	public static void addItem(int id,int quantity)
	{
		CartController.addItemController(id, quantity);
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void editItem(int id,int quantity)
	{
		CartController.editItemController(id, quantity);
	}
	/**
	 * 
	 * @param id
	 * 
	 */
	public static void removeItem(int id)
	{
		CartController.removeItemController(id);
	}
	/**
	 * 
	 * @return the total amount of the products
	 */
	public static double generateBill()
	{
		return CartController.billController();
	}
}
