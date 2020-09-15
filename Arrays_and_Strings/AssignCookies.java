package Arrays_and_Strings;
import java.util.*;

/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie. Each child i has a greed
 * factor gi, which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj. If sj >= gi, we can assign
 * the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0) return 0;
        if (s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = 0;
        for (int greed : g) {
            while (index < s.length) {
                if (s[index] >= greed) {
                    s[index] = 0;
                    index++;
                    result++;
                    break;
                }
                index++;
            }
        }
        return result;
    }
}
