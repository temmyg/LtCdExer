package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return e1[0]==e2[0] ? e1[1] - e2[1] : e1[0] - e2[0];
            }
        });

        int len = points.length;
        int i = 0;
        int grp = 0;
        while(i<len){
            grp++;
            int e = points[i][1];
            while(i<len && points[i][0]<=e){
                e = Math.min(e, points[i][1]);
                i++;
            }
        }

        return grp;
    }
}
