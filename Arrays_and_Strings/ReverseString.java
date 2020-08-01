package Arrays_and_Strings;

/*
    Write a function that reverses a string. The input string is given as an array of characters char[].
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

*/

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        char cache;
        while (i < j) {
            cache = s[j];
            s[j] = s[i];
            s[i] = cache;
            i++;
            j--;
        }
    }
}