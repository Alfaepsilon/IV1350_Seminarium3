package POSsys.dbHandler;

import POSsys.model.SaleLogDTO;

public class AccountingSystem {

	SaleLogDTO log;

	public void sendSaleInformation(SaleLogDTO saleLog) {
		log = saleLog;
		 //sends to database
	}

	public AccountingSystem() {
	}

}
