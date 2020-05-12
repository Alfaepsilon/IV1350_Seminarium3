package POSsys.controller;

import POSsys.model.PurchaseTime;

import POSsys.dbHandler.Store;
import POSsys.dbHandler.PointOfSale;

import java.util.ArrayList;
import java.util.List;

import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.InventorySystem;
import POSsys.dbHandler.ItemNotFoundException;
import POSsys.dbHandler.ItemRegister;
import POSsys.dbHandler.CashRegister;
import POSsys.model.CurrentPurchase;
import POSsys.model.Customer;
import POSsys.model.Receipt;
import POSsys.model.RunningTotal;
import POSsys.model.SaleLogDTO;
import POSsys.model.RevenueObserver;
import POSsys.view.TotalRevenueView;
import POSsys.dbHandler.Discount;
import POSsys.model.Item;
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

	private CurrentPurchase currentPurchase;

	private ItemRegister itemRegister;

	private Customer customer;

	private Receipt receipt;

	private SaleLogDTO saleLogDTO1;

	private Store store = new Store();

	private Discount discount;

	private PointOfSale pointOfSale;

	private SaleLogDTO saleLogDTO;

	private PurchaseTime purchaseTime;

	private CashRegister cashRegister;

	private double totalPrice;

	private double VATrate;
	
	private RunningTotal runningTotal = new RunningTotal();
	
	private List<RevenueObserver> revenueObservers =
			 new ArrayList<>();

	private Item[] shoppingCart = new Item[50];


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

	/** Denna funktion sätter information för POS och affären.
	* @author Henrik
	*/

	public void newSale() {
	  currentPurchase = new CurrentPurchase();
		store = store.getStoreInformation();
	}

	/**Denna funktion loggar köpet, skickar datan till en databas i form av en DTO, ökar värdet i kassan samt räknar ut växeln.
	* @author Henrik
	* @param pay
	* @param typeOfPayment
	* @param currency
	*/

	public String payment(double pay, String typeOfPayment, String currency) {
		purchaseTime = new PurchaseTime();
		currentPurchase.sendSaleInformation(saleLogDTO);
		register.increaseAmountPresentInRegisterWithAmountPaid(pay);
		runningTotal.getRunningTotal(pay);
		double change = register.calculateChange(pay, totalPrice);
		receipt = new Receipt(store, purTime, shoppingCart, totalPrice, VATrate, pay, change);
		saleLogDTO = new SaleLogDTO(pay, typeOfPayment, totalPrice, POS, discount, shoppingCart, purchaseTime, store, currency, VATrate);
		String output = receipt.printReceipt();
		notifyObservers(pay);
		return output;
   	 }

	/** Kollar om varan finns, hämtar den, lägger till den i kundvagnen samt uppdaterar lagret (item registry).
	* @author Henrik
	* @param itemIdentifier
	* @param quantity
	 * @throws Exception if the database was not found or if the item identifier doesn't match anything in it
	*/

	public void scanItem(String itemIdentifier, int quantity) throws Exception {
		boolean itemStatus = false;
		try {
			itemStatus = itemReg.checkItemStatus(itemIdentifier);
		} catch (Exception OperationFailedException) {
			throw OperationFailedException;
		}
		if (itemStatus){
			currentPurchase.addToShoppingCart(itemIdentifier, quantity);
			shoppingCart = currentPurchase.shoppingCart;
			itemReg.updateItemRegistry();
			VATrate = itemReg.VATrate;
			totalPrice += itemReg.getPrice(itemIdentifier, quantity) * VATrate;
	}
	}

	/** Skapar ett objekt av typen Discount, kollar om kunden är berättigad en rabatt och beräknar sedan rabatten kunden är berättigad.
	* @author Henrik
	* @param customerId
	*/

	public void discountRequest(String customerId) {
		discount = new Discount(customerId);
		boolean discountViability = discount.checkDiscountValidity(customerId);
		if(discountViability){totalPrice = discount.priceAfterDiscount(totalPrice);}
		currentPurchase.sendSaleInformation(saleLogDTO);
	}
	
	
	/** Notiferar varje revenueObserver om att det finns en ny pay
	* @author Amiran
	* @param pay
	*/
	private void notifyObservers(double pay) {
		 for (RevenueObserver revenueOb : revenueObservers) {
		 revenueOb.newRunningTotal(pay);
		 }
	}
	
	
	/** L�gger till en ny revenueObserver till revenueObservers arrayen i controller
	* @author Amiran
	* @param revenueOb
	*/
	public void addRevenueObserver(RevenueObserver revenueOb) {
		 revenueObservers.add(revenueOb);
	}
}


