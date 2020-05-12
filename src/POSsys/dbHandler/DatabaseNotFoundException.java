package POSsys.dbHandler;

public class DatabaseNotFoundException extends Exception{
	/**
	Konstruktorn för database exception
	@author Amiran
	*/
	DatabaseNotFoundException()
	{
		super("LOG:Database could not be called");
	}
}
