package POSsys.dbHandler;

import POSsys.model.SaleLogDTO;

public class AccountingSystem {

	SaleLogDTO log;
	
	public void sendSaleInformation(SaleLogDTO saleLog) {
		log = saleLog;
		return; //sends to database
	}

	public AccountingSystem AccountingSystem() {
		AccountingSystem obj = new AccountingSystem();
		return obj;
	}

}
