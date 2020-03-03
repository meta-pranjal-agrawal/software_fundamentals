package model;

public class Item 
{
	double price;
	String name;
	int quantity;
	
	public Item(String name,double price)
	{
		this.name=name;
		this.price=price;
	}
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	

}
