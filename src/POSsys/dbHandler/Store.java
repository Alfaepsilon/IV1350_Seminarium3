package POSsys.dbHandler;

public class Store {

	private String storeName;

	private String storeAddress;

	public Store() {
	}

	public Store getStoreInformation() {
		Store obj = new Store();
		obj.storeName = "quick e mart";
		obj.storeAddress = "washington";
		return obj; //uses database
	}

	public String getName()
	{
		return storeName;
	}

	public String getAddress()
	{
		return storeAddress;
	}

}
