package Arrays_and_Strings;

/* 
    Given a 32-bit signed integer, reverse digits of an integer.
    Input: 123
    Output: 321 

    Input: -123
    Output: -321

*/

public class ReverseInteger {
    public int reverse(int x) {
        long reversedValue = 0;
        while (x != 0) {
            reversedValue = reversedValue * 10 + x % 10;
            x = x / 10;
        }
        
        if (reversedValue < Integer.MIN_VALUE ||
            reversedValue > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)reversedValue;
        }

        
    }
}