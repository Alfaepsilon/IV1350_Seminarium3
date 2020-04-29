package POSsys.controller;

import POSsys.model.PurchaseTime;
import POSsys.dbHandler.Store;
import POSsys.dbHandler.PointOfSale;
import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.InventorySystem;
import POSsys.dbHandler.ItemRegister;
import POSsys.dbHandler.CashRegister;
import POSsys.model.CurrentPurchase;
import POSsys.model.Customer;
import POSsys.model.Receipt;
import POSsys.model.SaleLogDTO;
import POSsys.dbHandler.Discount;
/**
 *Den klass som delar upp alla "requests" till rätt funktioner.
 * @author Henri
 */
public class Controller {

	private PurchaseTime purTime = new PurchaseTime();

	private PointOfSale POS;

	private AccountingSystem accountingSystem;

	private InventorySystem inventorySystem;

	private ItemRegister itemReg;

	private CashRegister register = new CashRegister();

	private CurrentPurchase currentPurchase = new CurrentPurchase();

	private ItemRegister itemRegister;

	private Customer customer;

	private Receipt receipt;

	private SaleLogDTO saleLogDTO1;

	private Store store = new Store();

	private Discount discount = new Discount();

	private PointOfSale pointOfSale;

	private SaleLogDTO saleLogDTO = new SaleLogDTO();

	private PurchaseTime purchaseTime;

	private CashRegister cashRegister;

	private double totalPrice;

	private double VATrate;

	private String[] shoppingCart = new String[50];

	private int[] quantityCart = new int[50];

	/** Denna funktion sätter information för POS och affären.
	* @author Henrik*
	*/

	public void newSale() {
		currentPurchase = currentPurchase.CurrentPurchase();
		store = store.getStoreInformation();
		return;
	}

	/**Konstruktorn för controller
	* @author Henrik
	* @param store
  * @param POS
  * @param accountingSystem
  * @param inventorySystem
  * @param itemRegister
  * @param register
	*/

	public Controller(Store store, PointOfSale POS, AccountingSystem accountingSystem, InventorySystem inventorySystem, ItemRegister itemRegister, CashRegister register) {
		this.store = store;
		this.POS = POS;
		this.accountingSystem = accountingSystem;
		this.inventorySystem = inventorySystem;
		this.itemReg = itemRegister;
		this.register = register;
		return;
	}

	/**Denna funktion loggar köpet, skickar datan till en databas i form av en DTO, ökar värdet i kassan samt räknar ut växeln.
	* @author Henrik
	* @param pay
	* @param typeOfPayment
	* @param currency
	*/

	public void payment(double pay, String typeOfPayment, String currency) {
		purchaseTime = new PurchaseTime();
		currentPurchase.sendSaleInformation(saleLogDTO);
		register.increaseAmountPresentInRegisterWithAmountPaid(pay);
		double change = register.calculateChange(pay, totalPrice);
		receipt = new Receipt(store, purTime, shoppingCart, quantityCart, totalPrice, VATrate, pay, change);
		saleLogDTO = saleLogDTO.saleLog(pay, typeOfPayment, totalPrice, POS, discount, shoppingCart, quantityCart, purchaseTime, store, currency, VATrate);
		receipt.printReceipt();
		return;
	}

	/** Kollar om varan finns, hämtar den, lägger till den i kundvagnen samt uppdaterar lagret (item registry).
	* @author Henrik
	* @param itemIdentifier
	* @param quantity
	*/

	public void scanItem(String itemIdentifier, int quantity) {
		boolean itemStatus = itemReg.checkItemStatus(itemIdentifier);
		if (itemStatus){
			currentPurchase.addToShoppingCart(itemIdentifier, quantity);
			shoppingCart = currentPurchase.getCart();
			quantityCart = currentPurchase.getQuantity();
			itemReg.updateItemRegistry();
			VATrate = itemReg.getVAT();
			totalPrice += itemReg.getPrice(itemIdentifier, quantity) * VATrate;
	}
		else {System.out.println("error: no item available!");}
		return;
	}

	/** Skapar ett objekt av typen Discount, kollar om kunden är berättigad en rabatt och beräknar sedan rabatten kunden är berättigad. 
	* @author Henrik
	* @param customerId
	*/

	public void discountRequest(String customerId) {
		discount = discount.Discount(customerId);
		boolean discountViability = discount.checkDiscountValidity(customerId);
		if(discountViability){totalPrice = discount.priceAfterDiscount(totalPrice);}
		else {System.out.println("discount not available!");}
		currentPurchase.sendSaleInformation(saleLogDTO);
		return;
	}

}
