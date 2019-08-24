package Greedy;

public class MinimumAddForParenthesesValid_921 {
    public int minAddToMakeValid(String S) {
        int left = 0;
        int added = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='('){
                left++;
            }
            else{
                if(left==0){
                    added++;
                }
                else{
                    left--;
                }
            }
        }

        if(left>0){
            added += left;
        }

        return added;
    }
}
