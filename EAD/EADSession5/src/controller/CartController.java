package controller;

import java.util.HashMap;

import facade.CartFacade;
import model.Item;

public class CartController 
{
	/**
	 * 
	 * @return product list
	 */
	public static HashMap<Integer, Item> allAvailableItemsController(){
		HashMap<Integer, Item> products = CartFacade.allAvailableItemsFacade();
		return products;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void addItemController(int id,int quantity){
		CartFacade.addItemFacade(id, quantity);
	}
	
	/**
	 * 
	 * @return usercart
	 */
	public static HashMap<Integer, Item> getCartController()
	{
		HashMap<Integer, Item> userCart= CartFacade.getCartFacade();
		return userCart;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void editItemController(int id,int quantity)
	{
		CartFacade.editItemFacade(id, quantity);
	}
	
	/**
	 * 
	 * @param id
	 */
	public static void removeItemController(int id){
		CartFacade.removeItemFacade(id);
	}
	
	/**
	 * 
	 * @return total bill
	 */
	public static double billController()
	{
		return CartFacade.billFacade();
	}
}

