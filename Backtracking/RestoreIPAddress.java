package Backtracking;
import java.util.*;

/* 
Given a string s containing only digits. Return all possible valid IP addresses
 that can be obtained from s. You can return them in any order.
A valid IP address consists of exactly four integers, each integer is
 between 0 and 255, separated by single points and cannot have leading zeros.
  For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245",
   "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

   Example: 
    Input: s = "25525511135"
    Output: ["255.255.11.135","255.255.111.35"]

*/
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<String>();
        if (s == null || s.length() == 0) return output;
        
        int[] path = new int[4]; //get the four segments
        
        getAddresses(output, s, path, 0, 0);
        return output;
    }
    
    private void getAddresses(List<String> output, String s,
                             int[] path, int builderIndex, int segment) {
        if (segment == 4 && builderIndex == s.length()) {
            output.add(path[0] + "." + path[1] + "."
                    + path[2] + "." + path[3]);
        } else if (segment == 4 || builderIndex == s.length()) {
            return;
        } else {
            for (int len = 1; len <= 3 && len + builderIndex <= s.length(); len++) {
                String num = s.substring(builderIndex, builderIndex + len);
                if (Integer.parseInt(num) > 255 ||
                        len >= 2 && s.charAt(builderIndex) == '0') {
                    break;
                }
                path[segment] = Integer.parseInt(num);
                getAddresses(output, s, path, builderIndex + len, segment + 1);
                path[segment] = -1;
            }
        }
    }
}