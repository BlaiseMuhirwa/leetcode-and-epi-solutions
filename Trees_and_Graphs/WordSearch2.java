package Trees_and_Graphs;
import java.util.*;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 */
public class WordSearch2 {
    List<String> output = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0) return output;
        if(words == null || words.length == 0) return output;

        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j] &&
                            found != dfs(board, word, 0, i, j)){
                        found = true;
                        output.add(word);
                        break;
                    }
                }
                if (found) break;
            }
        }
        return output;
    }

    public boolean dfs(char[][] board, String word, int count, int i, int j) {
        if (word.length() == count) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(count)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = dfs(board, word, count+1, i+1, j) ||
                dfs(board, word, count+1, i-1, j) ||
                dfs(board, word, count+1, i, j+1) ||
                dfs(board, word, count+1, i, j-1);

        board[i][j] = temp;
        return found;
    }
}
