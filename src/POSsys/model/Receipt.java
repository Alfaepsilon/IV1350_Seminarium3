package POSsys.model;

import java.util.Arrays;

import POSsys.dbHandler.Store;

public class Receipt {

	private Store store;

	private PurchaseTime purchaseTime = new PurchaseTime();

	private String[] shoppingCart = new String[50];
	
	private int[] quantityCart = new int[50];

	private double totalPriceOfItems;

	private double VATrate;

	private double pay;

	private double change;

	/**
     * denna metod printar ut informationen som ska vara på kvittot som pris, datum osv
     */
	
	public void printReceipt() {
		System.out.println("Receipt \n" 
				+ "Store: " + store.getName() + " " + store.getAddress() + "\n" +
				"Date: " + purchaseTime.date + "\n" +
				"Shopping Cart: " + Arrays.toString(shoppingCart) + "\n" + "Quantity: " + Arrays.toString(quantityCart) + "\n" +
				"Price and vat-rate: " + totalPriceOfItems + " " + VATrate + "%\n" +
				"Payment and change: " + pay + " " + change);
		return; //outside of function
	}

	public Receipt(Store store, PurchaseTime purchaseTime, String[] shoppingCart, int[] quantityCart, double totalPriceOfItems, double VATrate, double pay, double change) {
		this.store = store;
		this.purchaseTime = purchaseTime;
		this.shoppingCart = shoppingCart;
		this.quantityCart = quantityCart;
		this.totalPriceOfItems = totalPriceOfItems;
		this.VATrate = VATrate;
		this.pay = pay;
		this.change = change;
		return;
	}

}
