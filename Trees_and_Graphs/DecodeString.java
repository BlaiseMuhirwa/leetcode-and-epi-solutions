package Trees_and_Graphs;

import java.util.*;
/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string
inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces,
square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits
and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
*/
public class Solution {
    private int position = 0;
    public String decodeString(String s) {
        //if (s == null || s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder();
        String number = "";
        for (int i = position; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number += s.charAt(i);
            }
            else if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == '[') {
                position = i+1;
                String temp = decodeString(s);
                for (int j=0; j < Integer.valueOf(number); j++) {
                    sb.append(temp);
                }
                number = "";
                i = position;
            }
            else if (s.charAt(i) == ']') {
                position = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}