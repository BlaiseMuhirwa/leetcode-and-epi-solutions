package more_problems;

import java.util.*;

public class OppositeSumProblem {
    public static int oppositeSum (int[] arr) {
        int counter = 0;
        //hashmap to contain arr[i] - rev[i] as key, and frequency as
        //value
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // compute number minus its reverse, and use this difference as 
            // a key in our hashmap
            int reverseDifference = arr[i] - reverseInt(arr[i]);
            map.put(reverseDifference, map.getOrDefault(reverseDifference, 0) + 1);//increment value

            if (map.containsKey(reverseDifference)) {
                //increment counter whenever we encounter a reversed difference that's already
                //in the hashmap
                counter += map.get(reverseDifference);
            }
        }
        return counter;
    }

    public static int reverseInt (int n) {
        int reverse = 0;
        while (n) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        /* try out a few examples and see if it works */
        int[] testArray1 = {1, 20, 2, 11};

        System.out.println(oppositeSum(testArray1)) //check to see if this gives the correct result

    }
}