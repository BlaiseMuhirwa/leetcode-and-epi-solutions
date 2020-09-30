package Arrays_and_Strings;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that
 * one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing
 * that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label
 * of the town judge.  Otherwise, return -1.
 */
public class FindTheTownJudge {
    /**
     * Time complexity: O(E) where E is the length of trust: the number of
     * directed edges in the graph relation
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        if (N == 0) return -1;
        if (N == 1) return 1;
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int[] relation : trust) {
            outDegree[relation[0]]++;
            inDegree[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
