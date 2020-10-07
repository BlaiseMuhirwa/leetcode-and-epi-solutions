package Dynamic_Programming;

/**
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose
 * the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of
 * weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible
 * weight of this stone (the weight is 0 if there are no stones left.)
 *
 *
 */
public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int sum = getSum(stones);
        int target = sum / 2;
        int[] remainder = new int[target + 1];
        int len = stones.length;

        for(int i = len; i >= 0; i--) {
            for(int currTarget = target; currTarget >= 0; currTarget--) {
                if (i == len) {
                    remainder[currTarget] = currTarget;
                    continue;
                }
                if (currTarget >= stones[i]) {
                    remainder[currTarget] = Math.min(remainder[currTarget],
                            remainder[currTarget - stones[i]]);
                }
            }
        }
        return sum - 2 * (target - remainder[target]);
    }


    public int getSum(int[] array) {
        int sum = 0;
        for (int num : array) sum += num;
        return sum;
    }
}
