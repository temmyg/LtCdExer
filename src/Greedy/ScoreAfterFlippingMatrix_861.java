package Greedy;

public class ScoreAfterFlippingMatrix_861 {
    public int matrixScore(int[][] A) {
        for(int i=0; i<A.length; i++){
            int locTot=0, revTot=0;
            for(int j=0; j<A[i].length; j++){
                locTot += locTot*2+A[i][j];
                revTot += revTot*2+1-A[i][j];
            }
            if(locTot<revTot){
                for(int j=0; j<A[i].length; j++){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        for(int i=0; i<A[0].length; i++){
            int ones = 0, zeroes = 0;
            for(int j=0; j<A.length; j++){
                if(A[j][i]==1){
                    ones++;
                }
                else{
                    zeroes++;
                }
            }
            if(ones<zeroes){
                for(int j=0; j<A.length; j++){
                    A[j][i] = 1 - A[j][i];
                }
            }
        }

        int total = 0;
        for(int i=0; i<A.length; i++){
            int rowTot = 0;
            for(int j=0; j<A[i].length; j++){
                rowTot = (rowTot*2) + A[i][j];
            }
            total += rowTot;
        }

        return total;
    }
}
