package POSsys.view;

import java.util.Scanner;

import POSsys.controller.Controller;
import POSsys.model.SaleLogDTO;
import POSsys.dbHandler.AccountingSystem;
import POSsys.dbHandler.InventorySystem;
import POSsys.model.Receipt;
import POSsys.dbHandler.CashRegister;
import POSsys.dbHandler.Store;
import POSsys.dbHandler.PointOfSale;
import POSsys.model.PurchaseTime;
import POSsys.dbHandler.ItemRegister;

/**
 * @author Henri
 * Själva vyn. Det är här användaren matar in och visas information.
 */
public class View {

	private Controller controller;
/**Konstruktorn till View-
* @author Henrik
* @author contr
*/
	public View(Controller contr) {
		this.controller = contr;
		contr.addRevenueObserver(new TotalRevenueView());
	}
/**Den funktion Main kallar på för att starta programmet. Det är också här all kod i View körs.
* @author Henrik
*/
	public void start() {
		Scanner scan = new Scanner(System.in);
		controller.newSale();
		System.out.println("new sale function completed, store and sale information acquired by system!");
		System.out.println("how many items do you want to scan?");
		int index = scan.nextInt();
		System.out.println("input item identifier and quantity of items for a scan");
		while(index > 0)
		{
			String itemIdentifier = scan.next();
			int quantity = scan.nextInt();
			try
			{
				controller.scanItem(itemIdentifier, quantity);
			}
			catch(Exception OperationFailedException)
			{
				ErrorMessageHandler.showErrorMsg(OperationFailedException.getMessage());
			}
			index--;
		}
		System.out.println("input customer id");
		String customerId = scan.next();
		controller.discountRequest(customerId);
		System.out.println("availability of discount received by the system!");
		System.out.println("input how much you're paying");
		double pay = scan.nextDouble();
		int i = 0;
		System.out.println("input type of payment");
		String typeOfPayment = scan.next();
		System.out.println("input currency type");
		String currency = scan.next();
		System.out.println(controller.payment(pay, typeOfPayment, currency));
		System.out.println("processing of payment completed and logged in the system!");
	}

}
