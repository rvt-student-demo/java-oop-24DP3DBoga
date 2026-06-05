package rvt;
import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> hashmap;
    
    public IOU() {
        hashmap = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        hashmap.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        if (!hashmap.containsKey(toWhom)) {
            return 0.0;
        }
        return hashmap.get(toWhom);
    }
}