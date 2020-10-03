package more_problems;

import java.util.*;
public class PrimeDecomposition {

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        print(findPrimeDecomposition(36));

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
            if (n % i == 0 && isPrime(i)) {
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
}
