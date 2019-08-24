package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        Integer[] ts = new Integer[]{0, 0, 0, 0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0, 0, 0};
        for(int i=0; i<tasks.length; i++){
            ts[tasks[i]-'A']++;
        }

        Arrays.sort(ts, new DescComparator());
        int total = 0;
        while(ts[0]!=0){
            ts[0]--;
            total++;
            int cool = 0;

            for(int i=1; i<=25; i++){
                if(cool<n && ts[i] > 0){
                    ts[i]--;
                    cool++;
                    total++;
                }
            }
            if(cool<n && ts[0]!=0){
                total += n-cool;
            }

            Arrays.sort(ts, new DescComparator());
        }

        return total;
    }
}

class DescComparator implements Comparator<Integer> {
    public int compare(Integer e1, Integer e2){
        return e2 - e1;
    }
}
