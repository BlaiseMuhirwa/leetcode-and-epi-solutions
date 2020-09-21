package Arrays_and_Strings;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique
 * (except for the order that it is in.)
 *
 *
 */
public class KClosestPointsToOrigin {
    /**
     * This algorithm runs in O(n+k(logn))
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) return null;
        PriorityQueue<Pair<Double, int[]>> minHeap =
                new PriorityQueue<Pair<Double, int[]>>(new Compare());

        int[][] output = new int[K][2];
        for (int[] point : points) {
            minHeap.add(new Pair(distance(point[0], point[1]),
                    new int[] {point[0], point[1]}));
        }
        int index = 0;
        while (K > 0) {
            Pair<Double, int[]> point = minHeap.poll();
            output[index] = point.getValue();
            K--;
            index++;
        }
        return output;
    }

    public double distance(int x, int y) {
        return (Math.sqrt((x*x) + (y*y)));
    }

    class Compare implements Comparator<Pair<Double, int[]>> {
        public int compare(Pair<Double, int[]> first,
                           Pair<Double, int[]> second) {
            double firstValue = first.getKey();
            double secondValue = second.getKey();
            if (firstValue < secondValue) return -1;
            else if (firstValue > secondValue) return 1;
            return 0;
        }
    }
}
