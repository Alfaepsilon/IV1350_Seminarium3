package POSsys.dbHandler;

public class CashRegister {

	private double amountPresentInRegister;

	 /**
     * Denna metod �kar hur mycket pengar som finns i amount variabeln i cashRegister med pay
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
		return pay - totalPrice;
	}

	public CashRegister() {
	}

}
