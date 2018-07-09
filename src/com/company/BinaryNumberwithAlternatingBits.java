package com.company;
// Bit
public class BinaryNumberwithAlternatingBits {
    /**
     * Given a positive integer, check whether it has alternating bits: namely,
     * if two adjacent bits will always have different values.
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        if (n==1 || n==0) return true;
        int i= (n&1);
        while (n!=0){
            n >>>= 1;
            if ((n&1) == i) return false;
            i ^= 1;
        }
        return true;
    }
}
