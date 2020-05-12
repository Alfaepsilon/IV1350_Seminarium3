package POSsys.startup;

import POSsys.controller.Controller;
import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.CashRegister;
import POSsys.dbHandler.InventorySystem;
import POSsys.dbHandler.ItemRegister;
import POSsys.dbHandler.PointOfSale;
import POSsys.dbHandler.Store;
import POSsys.view.View;

/**
 * Den klassen som initierar hela programmet.
 * @author Henri
 */
public class Main {

	/**
	* Målet med denna metod är att initiera allting som behövs för att programmet skall kunna köras, samt kalla på alla de metoder som skall exekveras i korrekt ordning.
 	* @param args
	* @author Henrik
	*/
	public static void main(String[] args) {
		CashRegister cashRegister = new CashRegister();
		Store store = new Store();
		PointOfSale pointOfSale = new PointOfSale();
		AccountingSystem accountingSystem = new AccountingSystem();
		InventorySystem inventorySystem = new InventorySystem();
		ItemRegister itemRegister = new ItemRegister();
		Controller controller = new Controller(store, pointOfSale, accountingSystem, inventorySystem, itemRegister, cashRegister);
		View view = new View(controller);
		view.start();
	}

}
