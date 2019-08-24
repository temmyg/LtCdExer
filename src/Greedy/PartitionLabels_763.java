package Greedy;

import java.util.*;

public class PartitionLabels_763 {
    //***!!
    public List<Integer> partitionLabels(String S) {
        Set<Integer> readSet = new HashSet<>();
        int[] counts = new int[26];

        for(int i=0; i<S.length(); i++){
            counts[S.charAt(i)-'a'] += 1;
        }

        List<Integer> res = new ArrayList<>();
        int partLen = 0;
        for(int i=0; i<S.length(); i++){
            partLen++;
            int charInt = S.charAt(i) - 'a';
            counts[charInt] -= 1;
            if(counts[charInt]==0){
                readSet.remove(charInt);
                if(readSet.size()==0){
                    res.add(partLen);
                    partLen = 0;
                }
            }
            else{
                if(!readSet.contains(charInt)){
                    readSet.add(charInt);
                }
            }
        }

        return res;
    }
}
