package DP;

public class DominoAndTrominoTiling_790 {
    public int numTilings(int N) {
        long[] dp = new long[N+1];
        
        if(N==1){
            return 1;
        }
        if(N==2){
            return 2;
        }
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int mod = 1000000007;
        for(int i = 4; i<=N; i++){
            dp[i] = (2*dp[i-1]+ dp[i-3]) % mod;
        }
        
        return (int)dp[N];
    }
}