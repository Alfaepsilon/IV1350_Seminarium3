package POSsys.model;

import POSsys.dbHandler.InventorySystem;
import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.ItemRegister;
import POSsys.dbHandler.PointOfSale;
import POSsys.dbHandler.Discount;
import POSsys.dbHandler.Store;
import POSsys.model.SaleLogDTO;
import POSsys.model.Item;
/** Denna klass representerar ett pågående köp
* @author Henrik
*/
public class CurrentPurchase {

	private int totalPriceOfItems;

	public Item[] shoppingCart = new Item[50];

	private int index = 0;

	private InventorySystem inventorySystem = new InventorySystem();

	private AccountingSystem accountingSystem = new AccountingSystem();
	
	private ItemRegister itemRegister = new ItemRegister();

/** Konstruktorn för CurrentPurchase
* @author Henrik
*/
	public CurrentPurchase() {
	}
/** Skickar all information om köpet till accountingSystem och inventorySystem
* @author Henrik
* @param obj
*/
	public void sendSaleInformation(SaleLogDTO obj)
	{
		accountingSystem.sendSaleInformation(obj);
		inventorySystem.sendSaleInformation(obj);
	}

/** Returnerar antalet av varorna
* @author Henrik
*/


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
			if(shoppingCart[i].itemIdentifier == itemName) {shoppingCart[i].quantity += quantity;}
		}
		if(index < shoppingCart.length)
		{
			shoppingCart[index] = itemRegister.createItem(itemName, quantity);
			index++;
		}
	}
}

