package POSsys.dbHandler;

import POSsys.model.CurrentPurchase;
import POSsys.model.Item;

public class ItemRegister {

	public double VATrate = 1.25;

	private Item apple = new Item("apples", 5, 10);
	private Item pear = new Item("pears", 10, 100);
	private Item banana = new Item("bananas", 15, 50);
	private Item meat = new Item("meat", 20, 25);
	private Item cheese = new Item("cheese", 25, 5);

	public Item[] databaseStorage = {apple, pear, banana, meat, cheese};


/**
	*Konstruktorn för ItemRegister
	*@author Henrik
	**/

	public ItemRegister(){

  }
	/**
     * får in namnet för en vara och hur många kunden vill ha och räknar ut dess pris
     * @param itemIdentifier
     * @param quantity
     * @return totalPrice
     */

	public int getPrice(String itemIdentifier, int quantity) {
		int totalPrice = 0;
		for(Item item : databaseStorage)
		{
			if(itemIdentifier.equals(item.getItemID())) {
				item.quantity -= quantity;
				totalPrice += item.getPrice() * quantity;
			}
		}
		return totalPrice;
	}

	/**
     * kollar om itemIdentifier är i shoppingCart arrayen och returnar ett boolean värde
     * @param itemIdentifier
     * @return true / false
     * @throws exception if the database was not found or if the item identifier doesn't match anything in it
     */

	public boolean checkItemStatus(String itemIdentifier) throws Exception{
		if(itemIdentifier.equals("cats")) //hardcoded identifier to test database exception
		{
			throw new DatabaseNotFoundException();
		}
		for(int i = 0; i < databaseStorage.length; i++)
		{
			if(databaseStorage[i].itemIdentifier.equals(itemIdentifier)) {return true;}
		}
		throw new ItemNotFoundException();
		//return false; //uses database to check if identifier exists normally
	}

	public void updateItemRegistry() {
	 //sends information to database normally
	}

/**
Denna funktion skapar en ny vara
@author Henrik
@param itemIdentifier
@param quantity
@return item
*/
	public Item createItem(String itemIdentifier, int quantity){
		int price = getPrice(itemIdentifier, quantity);
		Item item = new Item(itemIdentifier, quantity, price);
		return item;
	}

}
