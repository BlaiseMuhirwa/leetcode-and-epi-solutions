package more_problems;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = ((C-A) * (D-B)) + ((G-E) * (H-F));

        if (C <= E || G <= A || D <= F || H <= B) return area;
        int intersection = (Math.min(G, C) - Math.max(A, E)) *
                (Math.min(D, H) - Math.max(B, F));
        return area - intersection;
    }
}
