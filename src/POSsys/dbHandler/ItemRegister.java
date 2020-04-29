package POSsys.dbHandler;

import POSsys.model.CurrentPurchase;

public class ItemRegister {

	private double VATrate = 1.25;
	
	private String[] shoppingCart = {"apples", "pears", "bananas", "meat", "cheese"};
	
	private int[] quantityCart = {5, 10, 15, 20, 25};
	
	private int[] priceCart = {10, 100, 50, 25, 5};
	
	/**
     * f�r in namnet f�r en vara och hur m�nga kunden vill ha och r�knar ut dess pris
     * @param itemIdentifier
     * @param quantity
     * @return totalPrice
     */
	
	public int getPrice(String itemIdentifier, int quantity) {
		int totalPrice = 0;
		for(int i = 0; i < shoppingCart.length; i++)
		{
			if(itemIdentifier.equals(shoppingCart[i])) {
				quantityCart[i] -= quantity;
				if(quantityCart[i] < 0) {System.out.println("error, out of stock!");}
				totalPrice += priceCart[i] * quantity;
			}
		}
		return totalPrice;
	}
	
	public double getVAT()
	{
		return VATrate;
	}

	/**
     * kollar om itemIdentifier �r i shoppingCart arrayen och returnar ett boolean v�rde
     * @param itemIdentifier
     * @return true / false
     */
	
	public boolean checkItemStatus(String itemIdentifier) {
		for(int i = 0; i < shoppingCart.length; i++)
		{
			if(shoppingCart[i].equals(itemIdentifier)) {return true;}
		}
		return false; //uses database to check if identifier exists normally
	}
	
	public void updateItemRegistry() {
		return; //sends information to database normally
	}

}
