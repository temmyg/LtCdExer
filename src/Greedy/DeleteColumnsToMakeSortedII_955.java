package Greedy;

public class DeleteColumnsToMakeSortedII_955 {
    public int minDeletionSize(String[] A) {
        int W = A[0].length();
        int N = A.length;
        int tot = 0;
        boolean[] lastCuts = new boolean[A.length-1];

        search: for(int i=0; i<W; i++){
            for(int j=0; j<N-1; j++){
                if(!lastCuts[j] && A[j].charAt(i) > A[j+1].charAt(i)){
                    tot++;
                    continue search;
                }
            }

            for(int j=0; j<N-1; j++){
                if(A[j].charAt(i) < A[j+1].charAt(i)){
                    lastCuts[j] = true;
                }
            }
        }

        return tot;
    }
}
