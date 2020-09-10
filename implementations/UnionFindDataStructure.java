package implementations;

/**
 * Below is an implementation of the disjoint sets data structure
 * That uses quick union algorithm.
 * The find operation does not take constant time, but it is improved by
 * using path compression. Notice that union is done by comparing ranks of
 * the disjoint sets
 */
public class UnionFindDataStructure {
    public static void main(String[] args) {
        /* we have ten individuals: 0, 1, 2, 3, 4, 5, 6, 7, 8, ,9 */
        int n = 5;
        UnionFind sets = new UnionFind(n);
        sets.union(0, 1);
        sets.union(1, 3);
        sets.union(2, 5);
        sets.union(2, 8);
        sets.union(9, 4);
        sets.union(6, 9);

        /* check if person 0 is friends with person 3 */
        if (sets.find(0) == sets.find(3)) {
            System.out.println("Person 0 and Person 3 are connected");
        } else System.out.println("Person 0 and Person 3 are not connected");
        /* check if person 9 and person 2 are connected */
        if (sets.find(9) == sets.find(2)) {
            System.out.println("Person 9 and Person 2 are connected")
        } else System.out.println("Person 9 and Person 2 are not connected");

    }
}


class UnionFind {
    private int[] rank;
    private int[] parent;
    private int n;

    public UnionFind(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        makeSet();
    }

    public void makeSet() {
        /**
         * creates n sets with each item as its own root
         */
        for (int i = 0; i < this.n; i++) {
            parent[i] = i;
        }
    }
    public void union(int x, int y) {
        /**
         * unites two sets containing element x and element y
         */
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] += 1;
        }

    }
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


}
