package backtracking;
import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {

        
        List<String>res=new ArrayList<String>();
        if(digits.length() == 0) {
            return res;
        }
        Map<Integer,String>map=new HashMap<Integer, String>();
      
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
       
        combineLetters(res, new StringBuffer(), digits, digits.length(), map);
        return res;
       
   }

   public void combineLetters(List<String> res,StringBuffer sb,String s,int n, Map<Integer,String>map){
       
       if(sb.length()==n) {
           res.add(sb.toString());
           return;
       }
       
       for(int i=0;i<s.length();i++) {
           int val=s.charAt(i)-'0';
           String letters = map.get(val);
           for(int j=0; j < letters.length(); j++) {
               sb.append(letters.charAt(j));
               combineLetters(res, sb, s.substring(i+1,s.length()), n, map);
               sb.deleteCharAt(sb.length()-1);
           }
          
       }	 
   }
}