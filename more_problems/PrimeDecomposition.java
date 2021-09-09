package more_problems;

import java.util.*;
public class PrimeDecomposition {

    public static void main(String[] args) {
        //print(findPrimeDecomposition(36));
        //print(findPrimeDecomposition(15));
        //print(findPrimeDecomposition(27));
        System.out.println(findGCDRecursive(414, 662));
        System.out.println(findGCDRecursive(662, 414));
        System.out.println(findGCDRecursive(100, 100));
        System.out.println(findGCDRecursive(15679, 3551399));

    }
    public static List<Integer> findPrimeDecomposition(int n) {
        List<Integer> output = new ArrayList<>();
        decompose(n, 2, output);
        return output;
    }

    public static void decompose(int n, int i, List<Integer> decomposition) {
        if (n <= 1) return;
        if (isPrime(n)) {
            decomposition.add(n);
            return;
        } else {
            if (n % i == 0) {
                decomposition.add(i);
                decompose(n / i, i, decomposition);
            } else {
                decompose(n, i + 1, decomposition);
            }
        }
    }

    public static void print(List<Integer> list) {
        for (int num : list) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int findGCD(int x, int y) {
        if (x == y) return x;
        int r;
        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
    public static int findGCDRecursive(int x, int y) {
        if (y == 0) return x;
        return x >= y ? findGCDRecursive(y, x % y) :
                findGCDRecursive(y, x);
    }
}
