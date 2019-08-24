package Greedy;

import java.util.ArrayList;
import java.util.List;

public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        List<Integer[]> store = new ArrayList<>();
        int maxBefore = 0;
        for(int i=0; i<people.length; i++){
            if(people[i][1] > maxBefore){
                maxBefore = people[i][1];
            }
        }

        for(int i=0; i<=maxBefore; i++){
            for(int j=0; j<people.length; j++){
                if(people[j][1] == i){
                    int pCount = 0;
                    int k=0;
                    for(; k<store.size(); k++){
                        if(pCount >= i){
                            if(store.get(k)[0]>=people[j][0]){
                                store.add(k, new Integer[]{people[j][0], people[j][1]});
                                break;
                            }
                        }
                        if(store.get(k)[0] >= people[j][0]){
                            pCount++;
                        }
                    }
                    if(k==store.size()){
                        store.add(new Integer[]{people[j][0], people[j][1]});
                    }
                }
            }
        }

        int[][] res = new int[people.length][2];
        for(int i=0; i<store.size(); i++){
            res[i] = new int[]{store.get(i)[0], store.get(i)[1]};
        }
        return res;
    }
}
