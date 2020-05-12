package POSsys.view;

import POSsys.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
	/**
	 * Prints the runningTotal to the screen by calling printCurrentState
	 *
	 * @param runningTotal
	*/
    @Override
    public void newRunningTotal(double runningTotal){
        printCurrentState(runningTotal);
    }
    
    private void printCurrentState(double runningTotal){
        System.out.println("The current running price is: ");
        System.out.println(runningTotal);
    }
}
