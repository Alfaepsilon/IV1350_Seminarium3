package POSsys.model;

import POSsys.dbHandler.InventorySystem;
import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.ItemRegister;
import POSsys.dbHandler.PointOfSale;
import POSsys.dbHandler.Discount;
import POSsys.dbHandler.Store;
import POSsys.model.SaleLogDTO;
/** Denna klass representerar ett pågående köp
* @author Henrik
*/
public class CurrentPurchase {

	private int totalPriceOfItems;

	private String[] shoppingCart = new String[50];

	private int[] quantityCart = new int[50];

	private int index = 0;

	private InventorySystem inventorySystem = new InventorySystem();

	private AccountingSystem accountingSystem = new AccountingSystem();

/** Konstruktorn för CurrentPurchase
* @author Henrik
* @return obj
*/
	public CurrentPurchase CurrentPurchase() {
		CurrentPurchase obj = new CurrentPurchase();
		return obj;
	}
/** Skickar all information om köpet till accountingSystem och inventorySystem
* @author Henrik
* @param obj
*/
	public void sendSaleInformation(SaleLogDTO obj)
	{
		accountingSystem.sendSaleInformation(obj);
		inventorySystem.sendSaleInformation(obj);
		return;
	}
/** Returnerar kundvagnen
* @author Henrik
*/
	public String[] getCart()
	{
		return shoppingCart;
	}
/** Returnerar antalet av varorna
* @author Henrik
*/
	public int[] getQuantity()
	{
		return quantityCart;
	}
/** Sätter priset för hela köpet
* @author Henrik
*/
	public void setPrice(int price)
	{
		totalPriceOfItems = price;
	}

	/**adds the int quantity to the quantitycart int array based on the iteminformation matching the shoppingcart string array
	* @author Amiran
	* @param itemName
	* @param quantity
	*/

	public void addToShoppingCart(String itemName, int quantity) {
		for(int i = 0; i > shoppingCart.length; i++)
		{
			if(shoppingCart[i] == itemName) {quantityCart[i] += quantity; return;}
		}
		if(index < shoppingCart.length)
		{
			shoppingCart[index] = itemName;
			quantityCart[index] += quantity;
			index++;
		}
		else
		{
			System.out.println("out of shopping cart space!");
		}
		return;
	}
}
