package Greedy;

import java.util.Arrays;

public class BagsOfTokens_948 {
    //***!!
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens.length==0){
            return 0;
        }
        Arrays.sort(tokens);
        int min = 0;
        int max = tokens.length-1;
        int tots = 0;
        int pwr = P;
        while(min<max){
            if(pwr >= tokens[min]){
                pwr -= tokens[min];
                tots++;
                min++;
            }
            else{
                if(tots>0){
                    pwr += tokens[max];
                    tots--;
                }
                max--;
            }
        }

        if(pwr >= tokens[min]){
            tots++;
        }

        return tots;
    }
}
