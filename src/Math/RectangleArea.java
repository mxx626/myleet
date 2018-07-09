package Math;
// Math
public class RectangleArea {
    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.

     Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A);
        int area2 = (H-F)*(G-E);

        if (Math.min(G, C)<=Math.max(A, E) || Math.min(H, D)<=Math.max(F, B)) return area1+area2;
        return area1+area2-((Math.min(G, C)-Math.max(A, E))*(Math.min(H, D)-Math.max(F, B)));
    }
}
