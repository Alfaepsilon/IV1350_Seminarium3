package POSsys.model;

import java.util.Arrays;

import POSsys.dbHandler.Store;

import POSsys.model.Item;
public class Receipt {

	private Store store;

	private PurchaseTime purchaseTime = new PurchaseTime();

	private Item[] shoppingCart = new Item[50];

	private double totalPriceOfItems;

	private double VATrate;

	private double pay;

	private double change;

	/**
     * denna metod printar ut informationen som ska vara på kvittot som pris, datum osv
     */

	public String printReceipt() {
			String[] itemArray = new String[50];
			int[] quantityArray = new int[50];
			for(int i = 0; i < shoppingCart.length; i++)
			{
				if(shoppingCart[i] != null)
				{
					itemArray[i] = shoppingCart[i].itemIdentifier;
					quantityArray[i] = shoppingCart[i].quantity;
				}
			}
        	String output = ("Receipt \n"
                + "Store: " + store.getName() + " " + store.getAddress() + "\n" +
                "Date: " + purchaseTime.date + "\n" +
                "Shopping Cart: " + Arrays.toString(itemArray) + "\n" + "Quantity: " + Arrays.toString(quantityArray) + "\n" +
                "Price and vat-rate: " + totalPriceOfItems + " " + VATrate + "%\n" +
                "Payment and change: " + pay + " " + change);
        return output; //outside of function
    	}

	public Receipt(Store store, PurchaseTime purchaseTime, Item[] shoppingCart, double totalPriceOfItems, double VATrate, double pay, double change) {
		this.store = store;
		this.purchaseTime = purchaseTime;
		this.shoppingCart = shoppingCart;
		this.totalPriceOfItems = totalPriceOfItems;
		this.VATrate = VATrate;
		this.VATrate -= 1;
		this.VATrate *= 100;
		this.pay = pay;
		this.change = change;
	}

}
