package POSsys.model;

import java.util.ArrayList;
import java.util.List;

public class RunningTotal {
    private double runningTotal = 0;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    
    public void getRunningTotal(double pay){  
        runningTotal += pay;
        notifyObservers(runningTotal);
    }
    
    public void addRevenueObserver(RevenueObserver observer){
        revenueObservers.add(observer);
    }
    
    public void notifyObservers(double runningTotal) {
        for(RevenueObserver observer : revenueObservers){
            observer.newRunningTotal(runningTotal);
        }
    }
}
