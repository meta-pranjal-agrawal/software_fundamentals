package dao;

import java.util.HashMap;

import message.message;
import model.Item;

public class CartDao 
{
	static HashMap <Integer,Item> products= new HashMap<Integer,Item>();
	static HashMap <Integer,Item> userCart= new HashMap<Integer,Item>();
	
	/**
	 * 
	 * @return Available Items
	 */
	public static HashMap<Integer,Item> AvailableItems()
	{
		Item product1= new Item("Milk",20);
		Item product2= new Item("Butter",50);
		Item product3= new Item("Bread",30);
		Item product4= new Item("Eggs",10);
		
		products.put(1,product1);
		products.put(2,product2);
		products.put(3,product3);
		products.put(4,product4);
		
		return products;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void addItem(int id,int quantity)
	{
		if(userCart.containsKey(id))
		{
			int newQuantity=userCart.get(id).getQuantity() +quantity;
			userCart.get(id).setQuantity(newQuantity);
			System.out.println(message.ALREADYADDED + newQuantity);
		}
		else
		{
			products.get(id).setQuantity(quantity);
			userCart.put(id, products.get(id));
			System.out.println(message.ITEMADDED);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void editItem(int id,int quantity)
	{
		if(userCart.containsKey(id))
		{
			userCart.get(id).setQuantity(quantity);
			System.out.println(message.ITEMEDITED);
		}
		else
		{
			System.out.println(message.ITEMNOTINCART);
		}
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public static void removeItem(int id)
	{
		if(userCart.containsKey(id))
		{
			userCart.remove(id);
			System.out.println(message.ITEMREMOVED);
		}
		else
		{
			System.out.println(message.ITEMNOTINCART);
		}
	}
	
	/**
	 * 
	 * @return userCart
	 */
	public static HashMap<Integer,Item> getUserCart()
	{
		return userCart;
	}
	

}
