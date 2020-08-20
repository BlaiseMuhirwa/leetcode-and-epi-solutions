package arrays_and_strings;

/*
Given a string S and a character C, return an array of integers representing
 the shortest distance from the character C in the string.
 Input: S = "loveleetcode", C = 'e'
    Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

*/

public class ShortestDistanceToACharacter {
    /* We start with a brute-force solution where we store all indices of a C in a linked list.
        Then for every character, we compute the shortest distance by iterating through the values 
        in the linked list
        This takes O(n*k) where k is the number of occurences of C in the string, and n is the length of 
        the input string. It also takes O(k) space. 
        Below there is a linear-time algorithm which takes constant space
    */
    /*
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) return null;
        int len = S.length();
        int[] shortestDistances = new int[len];
        
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                LinkedList value = map.getOrDefault(C, new LinkedList<Integer>());
                value.add(i);
                map.put(C, value);
            }
        }
        for (int j = 0; j < len; j++) {
            if (S.charAt(j) == C) {
                shortestDistances[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                Iterator<Integer> iter = map.get(C).listIterator();
                while (iter.hasNext()) {
                    int index = iter.next();
                    min = Math.min(Math.abs(j - index), min);
                }
                shortestDistances[j] = min;
            }
        }
        return shortestDistances;
        
    }
    */
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) return null;
        int len = S.length();
        int[] shortestDistances = new int[len];
        int position = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                position = i;
            }
            shortestDistances[i] = Math.abs(i - position);
        }
        for (int i = len-1; i >=0; i--) {
            if (S.charAt(i) == C) {
                position = i;
            }
            shortestDistances[i] = Math.min(shortestDistances[i], Math.abs(i-position));
        }

        return shortestDistances;
        
    }

}