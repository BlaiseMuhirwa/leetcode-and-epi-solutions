package Arrays_and_Strings;
import java.util.*;

public class MaximizeSumOfArrayAfterKNegations {
    /**
     * This algorithm runs in O((N+K)logN) where N is the size of the
     * intput array. Space complexity is O(N)
     * @param A
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        if (K == 0) return sum(A);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for (int num : A) {
            minHeap.add(num);
            sum += num;
        }
        while (K > 0) {
            int min = minHeap.poll();
            sum -= min * 2;
            minHeap.add(-min);
            K--;
        }
        return sum;
    }

    private int sum (int[] A) {
        int sum = 0;
        for (int num : A) sum += num;
        return sum;
    }
}
