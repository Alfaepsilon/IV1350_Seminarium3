package POSsys.model;

public interface RevenueObserver {
	/**
	 * Invoked when runningTotal is updated
	 *
	 * @param runningTotal
	*/
    void newRunningTotal(double runningTotal);
}
