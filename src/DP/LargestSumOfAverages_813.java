package DP;

import java.lang.*;

public class LargestSumOfAverages_813 {
    int n;
    double[][] dp;
    public double largestSumOfAverages(int[] A, int K) {
        n = A.length;
        dp = new double[K+1][n];

        search(0, K, A);
        return dp[K][0];
    }

    public double search(int start, int remGrps, int[] A){
        double maxAve = Integer.MIN_VALUE;

        if(dp[remGrps][start]!=0){
            return dp[remGrps][start];
        }

        double accu = 0;
        int i = start;
        for(; i<n-(remGrps-1); i++){
            accu += A[i];
            if(remGrps!=1){
                maxAve = Math.max(maxAve, accu / (i-start+1) + search(i+1, remGrps-1, A));
                maxAve = maxAve;
            }
        }

        if(remGrps==1){
            maxAve = accu / (i-start);
        }

        dp[remGrps][start] = maxAve;
        return maxAve;
    }
}
