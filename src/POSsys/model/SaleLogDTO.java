package POSsys.model;

import POSsys.dbHandler.PointOfSale;
import POSsys.dbHandler.Discount;
import POSsys.dbHandler.Store;

public class SaleLogDTO {

	private String currency;

	private String typeOfPayment;

	private double totalPrice;

	private double change;

	private PointOfSale POS;

	private Discount discount;

	private Item[] shoppingCart = new Item[50];

	private PurchaseTime timeOfPurchase;

	private Store store;

	private double pay;

	private double VATrate;

	public SaleLogDTO(double pay, String typeOfPayment, double totalPrice, PointOfSale POS, Discount discount, Item[] shoppingCart, PurchaseTime timeOfPurchase, Store store, String currency, double VATrate) {
		this.pay = pay;
		this.typeOfPayment = typeOfPayment;
		this.totalPrice = totalPrice;
		this.change = change;
		this.POS = POS;
		this.discount = discount;
		this.shoppingCart = shoppingCart;
		this.timeOfPurchase = timeOfPurchase;
		this.store = store;
		this.currency = currency;
		this.VATrate = VATrate;
	}

}
