package Greedy;

public class BestTimeToBuySellStockII_122 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        int max = search(0, prices);
        return max;
    }

    public int search(int s, int[] prices){
        int prev = prices[s];
        int pt = s+1;

        while(pt < prices.length && prices[pt] > prev){
            prev = prices[pt];
            pt++;
        }

        if(pt == prices.length){
            return prices[prices.length-1] - prices[s];
        }
        else{
            return prices[pt-1] - prices[s] + search(pt, prices);
        }
    }
}
