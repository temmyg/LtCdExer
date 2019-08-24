package Greedy;

public class MonotoneIncreasingDigits_738 {
    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int len = nums.length;
        for(int i=len-2; i>=0; i--){
            if(nums[i]-'0'>nums[i+1]-'0'){
                nums[i] = (char)((nums[i]-(int)'0') - 1 + (int)'0');
                nums[i+1] = '9';
                for(int j=i+2; j<len; j++){
                    if(nums[j]!='9'){
                        nums[j] = '9';
                    }
                }
            }
        }

        return Integer.parseInt(new String(nums));
    }
}
