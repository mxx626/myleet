package com.company;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 * **/
public class Math_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int firstArea = (D-B)*(C-A);
        int secondArea = (H-F)*(G-E);
        int r = (Math.min(D, H) <= Math.max(B, F)) ? 0 : (Math.min(D, H)-Math.max(B, F));
        int c = (Math.min(G, C) <= Math.max(A, E)) ? 0 : (Math.min(G, C)-Math.max(A, E));
        return firstArea+secondArea-r*c;
    }
}
