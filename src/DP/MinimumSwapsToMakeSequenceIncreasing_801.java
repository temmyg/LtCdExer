package DP;

class MinimumSwapsToMakeSequenceIncreasing_801 {
	//***!!
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        //at index i, if A element is on the up position(not switched), the min switches needed
        int[] AUpMin = new int[n];
        int[] BUpMin = new int[n];
        AUpMin[0] = 0;
        BUpMin[0] = 1;
        
        for(int i=1; i<n; i++){
            int tmpA = Integer.MAX_VALUE, tmpB = Integer.MAX_VALUE;
            
            //last A up(A[i-1] and B[i-1] is not switched) and switch at i
            if(B[i] > A[i-1] && A[i] > B[i-1]){
                tmpB = AUpMin[i-1] + 1;
            }
            
            //last A up and not switch at i
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                tmpA = AUpMin[i-1];
            }
            
            //last B up(A[i-1] and B[i-1] is switched) and not switch at i
            if(A[i] > B[i-1] && B[i] > A[i-1]){
                tmpA = Math.min(tmpA, BUpMin[i-1]);
            }
            
            //last B up and switch at i
            if(B[i]> B[i-1] && A[i] > A[i-1]){
                tmpB = Math.min(tmpB, BUpMin[i-1] + 1);
            }
            
            AUpMin[i] = tmpA;
            BUpMin[i] = tmpB;
        }
        
        return Math.min(AUpMin[n-1], BUpMin[n-1]);
    }
}