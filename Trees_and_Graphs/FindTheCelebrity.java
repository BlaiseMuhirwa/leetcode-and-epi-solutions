package Trees_and_Graphs;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1)
 * and among them, there may exist one celebrity. The definition of a
 * celebrity is that all the other n - 1 people know him/her but
 * he/she does not know any of them.
 * Time complexity: O(n), space:O(1)
 */
public class FindTheCelebrity extends Relation {
    int n;
    public int findCelebrity(int n) {
        this.n = n;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        if (isCelebrity(candidate)) return candidate;
        return -1;
    }

    public boolean isCelebrity(int candidate) {
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                return false;
            }
        }
        return true;
    }
}

