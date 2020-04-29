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

	private String[] shoppingCart = new String[50];
	
	private int[] quantityCart = new int[50];

	private PurchaseTime timeOfPurchase;

	private Store store;

	private double pay;

	private double VATrate;

	public SaleLogDTO saleLog(double pay, String typeOfPayment, double totalPrice, PointOfSale POS, Discount discount, String[] shoppingCart, int[] quantityCart, PurchaseTime timeOfPurchase, Store store, String currency, double VATrate) {
		SaleLogDTO obj = new SaleLogDTO();
		obj.pay = pay;
		obj.typeOfPayment = typeOfPayment;
		obj.totalPrice = totalPrice;
		obj.change = change;
		obj.POS = POS;
		obj.discount = discount;
		obj.shoppingCart = shoppingCart;
		obj.quantityCart = quantityCart;
		obj.timeOfPurchase = timeOfPurchase;
		obj.store = store;
		obj.currency = currency;
		obj.VATrate = VATrate;
		return obj;
	}

}
