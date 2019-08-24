package Greedy;

public class CanCompleteCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] atNextStationLeft = new int[gas.length];

        for(int i=0; i<gas.length; i++){
            atNextStationLeft[i] = gas[i] - cost[i];
        }

        for(int i=0; i<gas.length; i++){
            int left = atNextStationLeft[i];
            int count = 1;
            int j = i;
            while(count<gas.length && left>=0){
                count++;
                j = (j+1) % gas.length;
                left += atNextStationLeft[j];
            }

            if(count == gas.length && left >= 0){
                return i;
            }
        }

        return -1;
    }
}
