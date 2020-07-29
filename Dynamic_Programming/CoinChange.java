package Dynamic_Programming;
import java.util.*;

public class CoinChange {
    /* This solution takes O(n*amount) where n is the length of the coins array. 
            1. First we loop through every cent from 0 up to the value we are given. 
            2. for every amount, we find the minimum number of coins required to get that amount using a recurrence relation.
                If d_i is the first coin in the optimal solution for making change for x cents, 
                then C[x] =  1 + C[x - d_i] since C[x - d_i] is the optimal number of coins required to make change for x - d_i
                (you can prove by contradiction that the above recurrence gives an optimal solution).
            
            3. Then we check the value in the last position to return either -1 if no change can be made, or the optimal 
                solution if change can be made. 
            
    */
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[] minCount = new int[amount+1];
        Arrays.fill(minCount, amount+1);
        minCount[0] = 0;
        
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    minCount[i] = Math.min(minCount[i], minCount[i-coin]+1);
                  
                }
            }
        }
        if (minCount[amount] > amount) {
            return -1;
        }
        else {
            return minCount[amount];
        }
    }
}