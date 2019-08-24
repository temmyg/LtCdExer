package Greedy;

import java.util.Arrays;

public class SmallestRangeII_910 {
    //***!!
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int max = A[A.length-1] - K;
        int min = A[0] + K;
        int minRan = A[A.length-1] - A[0];

        for(int i=0; i<A.length-1; i++){
            int top = Math.max(A[i]+K, max);
            int bottom = Math.min(A[i+1]-K, min);
            minRan = Math.min(top-bottom, minRan);
        }

        return minRan;
    }
}
