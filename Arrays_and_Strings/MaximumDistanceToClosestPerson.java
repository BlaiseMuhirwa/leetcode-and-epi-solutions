package Arrays_and_Strings;
/* 
In a row of seats, 1 represents a person sitting in that seat, and 0
represents that the seat is empty. 
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him
and the closest person to him is maximized. 
Return that maximum distance to closest person

*/
public class MaximumDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) return 0;
        int ans = 0;
        int N = seats.length;
        int prev = -1;
        int next = 0;
        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) {
                prev = i;
            }
            else {
                while (next < N && seats[next] == 0 || next < i) {
                    next++;
                }
                int left = prev == -1 ? N : i - prev;
                int right = next == N ? N : next - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }
        return ans;
    }
}