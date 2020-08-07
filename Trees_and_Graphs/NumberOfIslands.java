package trees_and_graphs;

/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example:
        Input: grid = [
                        ["1","1","1","1","0"],
                        ["1","1","0","1","0"],
                        ["1","1","0","0","0"],
                        ["0","0","0","0","0"]
                      ]
                Output: 1
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    depthFirstSearch(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void depthFirstSearch(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
           grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; /* here we mark any land we pass on as water before recursing on the next item */
        depthFirstSearch(grid, i, j+1);
        depthFirstSearch(grid, i, j-1);
        depthFirstSearch(grid, i+1, j);
        depthFirstSearch(grid, i-1, j);
        //return 1;
    }
}