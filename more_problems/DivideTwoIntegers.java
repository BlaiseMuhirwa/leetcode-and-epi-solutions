package more_problems;

/**
 *
 Given two integers dividend and divisor, divide two integers without using
 multiplication, division, and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero, which means losing its
 fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 */
public class DivideTwoIntegers {
    /**
     * Time complexity: O(n) where n is the absolute value of the dividend
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        /*convert both numbers to negatives in order to handle
            edge cases correctly */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend <= divisor) {
            quotient++;
            dividend -= divisor;
        }
        if(negatives == 1) {
            return -quotient;
        }
        return quotient;
    }
}
