package POSsys.dbHandler;

import java.util.ArrayList;
import java.util.List;

import POSsys.model.RevenueObserver;

public class CashRegister {

	private double amountPresentInRegister;
	private List<RevenueObserver> revenueObservers =
			 new ArrayList<>();

	 /**
     * Denna metod ï¿½kar hur mycket pengar som finns i amount variabeln i cashRegister med pay
     * @param pay
     */

	public void increaseAmountPresentInRegisterWithAmountPaid(double pay) {
		amountPresentInRegister += pay;
	}

	public double getAmount()
	{
		return amountPresentInRegister;
	}

	/**
     * Denna metod subtraherar hur mycket pengar kunden gav med priset av varorna
     * @param pay
     * @param totalPrice
     * @return totalPrice - pay
     */

	public double calculateChange(double pay, double totalPrice)
	{
		double change = 0;
        	if(pay - totalPrice >= 0)
        	{
           	 amountPresentInRegister -= (pay - totalPrice);
           	 change = pay - totalPrice;
      	       }
        	notifyObservers();
        	return change;
	}

	public CashRegister() {
	}
	
	/** Notiferar varje revenueObserver om att det finns en ny pay
	* @author Amiran
	* @param pay
	*/
	private void notifyObservers() {
		 for (RevenueObserver revenueOb : revenueObservers) {
		 revenueOb.newRunningTotal(amountPresentInRegister);
		 }
	}
	
	
	/** Lägger till en ny revenueObserver till revenueObservers arrayen i cashregister
	* @author Amiran
	* @param revenueObservers2
	*/
	public void addRevenueObserver(List<RevenueObserver> revenueObservers2) {
		 revenueObservers.addAll(revenueObservers2);
	}

}
