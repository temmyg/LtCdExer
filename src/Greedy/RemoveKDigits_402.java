package Greedy;

public class RemoveKDigits_402 {
    int len;
    public String removeKdigits(String num, int k) {
        len = num.length();
        char[] nums = num.toCharArray();

        for(int i=0; i<len; i++){
            if(k==0){
                break;
            }
            for(int j=i-1; j>=0; j--){
                if(nums[j]!='-' && nums[j] > nums[i]){
                    nums[j] = '-';
                    k--;
                    if(k==0){
                        break;
                    }
                }
            }
        }

        if(k>0){
            for(int i=0; i<len; i++){
                if(nums[len-1-i]!='-'){
                    nums[len-1-i] = '-';
                    k--;
                }
                if(k==0){
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        boolean metNonZero = false;
        for(int i=0; i<len; i++){
            if(nums[i]!='-'){
                if(nums[i] != '0'){
                    if(!metNonZero){
                        metNonZero = true;
                    }

                    res.append(nums[i]);
                }
                if(nums[i] == '0'){
                    if(metNonZero){
                        res.append(nums[i]);
                    }
                }
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
