package Arrays_and_Strings;
import java.util.*;

public class IntersectionOfTwoArrays {
        /* This algorithm runs in O(n) time with O(m) space
        where n is the size of the larger array and m is the size 
        of the smaller array
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }
        if (len1 < len2) {
            return helper(nums1, nums2);
        }
        else {
            return helper(nums2, nums1);
        }
        
    }
    private int[] helper(int[] first, int[] second) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < first.length; i++) {
            /* use val to avoid nullpointerexception */
            int val = map.getOrDefault(first[i], -1); 
            if (val == -1) {
                map.put(first[i], 1);
            }
            else {
                map.put(first[i], map.get(first[i])+1);
            }
        }
        for (int j = 0; j < second.length; j++) {
            if (map.containsKey(second[j])) {
                int val = map.getOrDefault(second[j], -1);
                if (val == -1) {
                    continue;
                }
                else if (val > 0) {
                    list.add(second[j]);
                    map.put(second[j], val-1);
                }
            }
        }
        int[] intersection = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            intersection[k] = list.get(k);
        }
        return intersection;
    }
}
