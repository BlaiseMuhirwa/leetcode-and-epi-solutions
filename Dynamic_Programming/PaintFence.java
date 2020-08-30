package Dynamic_Programming;
/* 
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

*/
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        
        /* possibilities for painting 2 posts either with same or different color*/
        int same = k;
        int different = k * (k - 1);
        
        for (int i = 3; i <= n; i++) {
            int previousDifferent = different;
            different = (same + different) * (k - 1);
            same = previousDifferent;
        }
        return same + different;
    }
}