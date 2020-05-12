package POSsys.view;

public interface RevenueObserver {
	/**
	 * Invoked when runningTotal is updated
	 *
	 * @param runningTotal
	*/
    void newRunningTotal(double runningTotal);
}
