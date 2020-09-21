package Arrays_and_Strings;
import java.util.PriorityQueue;

/**
 *
 We have a collection of stones, each stone has a positive integer weight.

 Each turn, we choose the two heaviest stones and smash them together.
 Suppose the stones have weights x and y with x <= y.  The result of this smash is:

 If x == y, both stones are totally destroyed;
 If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int stone : stones) {
            maxHeap.add(-stone);
        }

        while (maxHeap.size() > 0) {
            if (maxHeap.size() == 1) {
                return -maxHeap.poll();
            }
            int first = -maxHeap.poll();
            int second = -maxHeap.poll();

            if (first == second) continue;
            else {
                maxHeap.add(-(first - second));
            }
        }
        return 0;
    }
}
