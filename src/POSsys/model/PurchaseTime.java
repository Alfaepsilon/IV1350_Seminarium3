package POSsys.model;

import java.util.Date;

public class PurchaseTime {

	java.util.Date date = new java.util.Date();  

	public PurchaseTime PurchaseTime() {
		PurchaseTime obj = new PurchaseTime();
		return obj;
	}
	
	public Date getDate()
	{
		return date;
	}
}
