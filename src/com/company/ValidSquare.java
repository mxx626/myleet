package com.company;
// TAG: Math
public class ValidSquare {
    /**
     * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

     The coordinate (x,y) of a point is represented by an integer array with two integers.

     Example:
     Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     Output: True
     Note:

     All the input integers are in the range [-10000, 10000].
     A valid square has four equal sides with positive length and four equal angles (90-degree angles).
     Input points have no order.

     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        return construct(p1,p2,p3,p4)||construct(p1,p3,p2,p4)||construct(p1,p2,p4,p3);
    }
    
    private boolean construct (int[] a, int[] b, int[] c, int[] d){
        return compute(a,b)>0
                &&(compute(a,b)==compute(b,c))
                &&(compute(b,c)==compute(c,d))
                &&(compute(c,d)==compute(d,a))
                &&(compute(d,a)==compute(a,b))
                &&(compute(a,c)==compute(b,d));
    }


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (!contruct(p1, p2, p3, p4)) return false;
        if (compute(p1, p2)==compute(p2, p4)){
            if (compute(p2, p3)==compute(p1, p4) && compute(p3, p4)==compute(p1, p2)) return true;
        }
        else if (compute(p1, p2)>compute(p2, p4)){
            if (compute(p1, p2)==compute(p3, p4) && compute(p1, p3)==compute(p1, p4)) return true;
        }
        else {
            if (compute(p2, p4)==compute(p1, p3) && compute(p2, p1)==compute(p2, p3)) return true;
        }
        return false;
    }
    private int compute(int[] p1, int[] p2){
        return (p2[0]-p1[0])*(p2[0]-p1[0])+(p2[1]-p1[1])*(p2[1]-p1[1]);
    }
    private boolean contruct (int[] a, int[] b, int[] c, int[] d){
        if(a[0]==b[0] && (a[0]==c[0] || a[0]==d[0])) return false;
        if(c[0]==d[0] && (a[0]==c[0] || b[0]==c[0])) return false;
        if(a[1]==b[1] && (a[1]==c[1] || a[1]==d[1])) return false;
        if(c[1]==d[1] && (a[1]==c[1] || b[1]==c[1])) return false;
        return true;
    }
}
