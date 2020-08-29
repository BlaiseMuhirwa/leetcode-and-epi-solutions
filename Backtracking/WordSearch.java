package Backtracking;
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
  The same letter cell may not be used more than once.

Example:
  board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null) return true;
        if (board == null) return false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) &&
                    /* we keep count of how many characters we've found so far */
                    /* we also don't return the result of dfs iteration because
                        we can have many occurences of the starting character */
                   dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int count, int i, int j) {
        if (word.length() == count) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
           board[i][j] != word.charAt(count)) {
            return false;
        }
        char temp = board[i][j]; /* we need to store this character for next recursive calls */
        board[i][j] = ' ';
        boolean found =  dfs(board, word, count+1, i+1, j) ||
            dfs(board, word, count+1, i-1, j) ||
            dfs(board, word, count+1, i, j+1) ||
            dfs(board, word, count+1, i, j-1);
        
        board[i][j] = temp;
        return found;
    }
}