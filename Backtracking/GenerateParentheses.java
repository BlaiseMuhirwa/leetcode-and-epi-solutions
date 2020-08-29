package Backtracking;
import java.util.*;

public class GenerateParentheses {
    private List<String> parentheses = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return parentheses;
        if (n == 1) {
            parentheses.add("()");
            return parentheses;
        }
        combine(parentheses, "", n, n);
        return parentheses;
    }
    
    private void combine(List<String> parentheses, String current, 
                        int left, int right) {
        if (left == 0 && right == 0) {
            parentheses.add(current);
            return;
        }
        if (left < 0 || left > right) {
            return;
        }
        combine(parentheses, current + "(", left-1, right);
        combine(parentheses, current + ")", left, right -1);
    }
}