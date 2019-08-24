package Greedy;

import java.util.*;

//***!!
public class BoatsToSavePeople_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i=0, j=people.length-1;
        while(i<j){
            boats++;
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
        }
        if(i==j){
            boats++;
        }
        return boats;
    }
    // using PriorityQueue, time limit exceed
    public int numRescueBoats0(int[] people, int limit) {
        int boatCount = 0;
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(100, Collections.reverseOrder());
        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<people.length; i++){
            workQueue.offer(people[i]);
        }

        while(!workQueue.isEmpty()){
            int first = workQueue.poll();
            boatCount++;
            int rem = limit - first;
            while(!workQueue.isEmpty()){
                int next = workQueue.poll();
                if(rem>=next){
                    break;
                }
                temp.add(next);
            }
            if(temp.size()>0){
                workQueue.addAll(temp);
                temp.clear();
            }
        }

        return boatCount;
    }
    //using array
    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        for(int i=0; i<people.length/2; i++){
            int tmp = people[i];
            people[i] = people[people.length-1-i];
            people[people.length-1-i] = tmp;
        }
        int boatCount = 0;
        int i=0;
        while(i<people.length){
            if(people[i]!=-1){
                boatCount++;
                int j = i + 1;
                while(j<people.length){
                    if(people[j]!=-1 && people[j] <= limit-people[i]){
                        people[j] = -1;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        return boatCount;
    }
}
