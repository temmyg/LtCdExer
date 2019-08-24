package Greedy;

import java.util.*;

public class AdvantageShuffle_870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] copyB = B.clone();
        Map<Integer, List<Integer>> store = new HashMap<>();

        Arrays.sort(A);
        Arrays.sort(B);
        int minA = A[0];
        int i=0, j=0;
        int len = A.length;

        while(i<len){
            if(A[i]>B[j]){
                if(!store.containsKey(B[j])){
                    store.put(B[j], new ArrayList());
                }
                store.get(B[j]).add(A[i]);
                A[i] = minA-1;
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        int last = -1;
        i=0;
        int[] ret = new int[len];
        for(; i<len; i++){
            if(store.containsKey(copyB[i]) && store.get(copyB[i]).size()>0){
                List<Integer> matched = store.get(copyB[i]);
                ret[i] = matched.get(0);
                matched.remove(0);
            }
            else{
                last = findNext(A, last+1, minA-1);
                ret[i] = A[last];
            }
        }

        return ret;
    }

    public int findNext(int[] sortedA, int i, int used){
        int j=i;
        while(j<sortedA.length){
            if(sortedA[j]!=used){
                return j;
            }
            j++;
        }

        return -1;
    }
}
