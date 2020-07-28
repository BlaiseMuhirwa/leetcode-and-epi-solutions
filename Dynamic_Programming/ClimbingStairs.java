package Dynamic_Programming;

public class ClimbingStairs {
    /* 
    This algorithm runs in O(n) time with O(n) space
    */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        for (int i = 3; i<n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1]; 
    }

}

