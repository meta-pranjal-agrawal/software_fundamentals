package facade;

import java.util.HashMap;

import dao.CartDao;
import model.Item;

public class CartFacade 
{
	/**
	 * 
	 * @return available items
	 */
	public static HashMap<Integer, Item> allAvailableItemsFacade()
	{
		HashMap<Integer, Item> products=CartDao.AvailableItems();
		return products;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void addItemFacade(int id,int quantity)
	{
		CartDao.addItem(id, quantity);
	}
	
	/**
	 * 
	 * @return usercart
	 */
	public static HashMap<Integer, Item> getCartFacade()
	{
		HashMap<Integer, Item> userCart= CartDao.getUserCart();
		return userCart;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 */
	public static void editItemFacade(int id,int quantity){
		CartDao.editItem(id, quantity);
	}
	
	/**
	 * 
	 * @param id
	 */
	public static void removeItemFacade(int id){
		CartDao.removeItem(id);
	}
	
	/**
	 * 
	 * @return total bill
	 */
	public static double billFacade()
	{
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity() * entry.getValue().getPrice();
		return amount;
	}
	

}
