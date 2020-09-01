package Trees_and_Graphs;
/*

An image is represented by a 2-D array of integers, each integer representing
the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column)
of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected
4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same
color as the starting pixel), and so on. Replace the color of all of the
aforementioned pixels with the newColor.

At the end, return the modified image.
*/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return image;
        
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, 
                     int newColor, int prevColor) {
        if (row < 0 || row >= image.length || col < 0 ||
           col >= image[0].length || image[row][col] != prevColor ||
           prevColor == newColor) {
            return;
        }
        if (image[row][col] == prevColor) {
            image[row][col] = newColor;
            dfs(image, row - 1, col, newColor, prevColor);
            dfs(image, row + 1, col, newColor, prevColor);
            dfs(image, row, col + 1, newColor, prevColor);
            dfs(image, row, col - 1, newColor, prevColor);
        } else {
            return;
        }
        
    }
}