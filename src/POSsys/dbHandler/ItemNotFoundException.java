package POSsys.dbHandler;

public class ItemNotFoundException extends Exception
{
	/**
	Konstruktorn för database exception
	@author Amiran
	*/
	ItemNotFoundException()
	{
		super("Item with that name was not found in the register");
	}
}
