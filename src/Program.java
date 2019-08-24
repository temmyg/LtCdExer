import DP.LargestSumOfAverages_813;
import Greedy.*;

public class Program {
    public static void main(String[] args){
        BoatsToSavePeople_881 bts = new BoatsToSavePeople_881();
        bts.numRescueBoats(new int[]{3, 2, 3, 2, 2,}, 6);

        AdvantageShuffle_870 as = new AdvantageShuffle_870();
        as.advantageCount(new int[]{2,7,11,15}, new int[]{1, 10, 4, 11});

        PartitionLabels_763 pl = new PartitionLabels_763();
        pl.partitionLabels("ababcbacadefegdehijhklij");

        SplitArrayConsecutiveSequence_659 sac = new SplitArrayConsecutiveSequence_659();
        boolean res = sac.isPossible(new int[]{1,2,3,3,4,4,5,5});

        TaskScheduler_621 ts = new TaskScheduler_621();
        ts.leastInterval(new char[]{'A','B','C','D','E','A','B','C','D','E'}, 4);

        NoOverlappingIntervals_435 noi = new NoOverlappingIntervals_435();
        noi.eraseOverlapIntervals(new int[][]{{1,100}, {11, 22}, {1, 11}, {2, 12}});

        QueueReconstructionByHeight_406 qrbh = new QueueReconstructionByHeight_406();
        qrbh.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});

        RemoveKDigits_402 rkd = new RemoveKDigits_402();
        rkd.removeKdigits("1234567890", 10);

        LargestSumOfAverages_813 lsa = new LargestSumOfAverages_813();
        lsa.largestSumOfAverages(new int[]{9,1,2,3,9}, 3);
    }
}
