package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NoOverlappingIntervals_435 {
    //***!!
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0];
            }
        });

        int len = intervals.length;
        int i = 0;
        int rmvs = 0;
        int s, e;
        while(i<len){
            s = intervals[i][0];
            e = intervals[i][1];
            i++;
            while(i<len && intervals[i][0] == s){
                intervals[i][0] = Integer.MAX_VALUE;
                rmvs++;
                i++;
            }
        }

        e = intervals[0][1];
        i = 1;
        while(i<len){
            s = intervals[i][0];
            if(s!=Integer.MAX_VALUE){
                if(s < e){
                    if(intervals[i][1]<=e){
                        e = intervals[i][1];
                        rmvs++;
                    }
                    else{
                        rmvs++;
                    }
                }
                else{
                    e = intervals[i][1];
                }
            }
            i++;
        }

        return rmvs;
    }
}
