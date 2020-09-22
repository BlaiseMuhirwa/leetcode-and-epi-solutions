package Arrays_and_Strings;

/**
 *
 Given a non-negative integer num, return the number of steps to reduce it to zero.
 If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps (int num) {
        if (num == 0) return 0;
        int counter = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            counter += 1;
        }
        return counter;
    }
}
