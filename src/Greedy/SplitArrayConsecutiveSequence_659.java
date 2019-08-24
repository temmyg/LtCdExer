package Greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayConsecutiveSequence_659 {
    //***!!
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> stored = new HashMap<>();
        Map<Integer, Integer> endingCount = new HashMap<>();

        for(int num : nums){
            stored.put(num, stored.getOrDefault(num, 0) + 1);
        }

        for(int num : nums){
            if(stored.getOrDefault(num, 0)==0){
                continue;
            }
            if(endingCount.getOrDefault(num-1, 0)>0){
                endingCount.put(num-1, endingCount.get(num-1)-1);
                endingCount.put(num, endingCount.getOrDefault(num, 0)+1);
            }
            else if(stored.getOrDefault(num+1, 0)>0 && stored.getOrDefault(num+2, 0)>0){
                endingCount.put(num+2, endingCount.getOrDefault(num+2, 0)+1);
                stored.put(num+1, stored.get(num+1)-1);
                stored.put(num+2, stored.get(num+2)-1);
            }
            else{
                return false;
            }
            stored.put(num, stored.get(num)-1);
        }

        return true;
    }
}
