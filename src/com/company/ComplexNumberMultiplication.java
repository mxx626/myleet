package com.company;
// TAG: String
public class ComplexNumberMultiplication {
    /**
     * Given two strings representing two complex numbers.
     * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
     *
     * Example 1:
     * Input: "1+1i", "1+1i"
     * Output: "0+2i"
     * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     *
     * Example 2:
     * Input: "1+-1i", "1+-1i"
     * Output: "0+-2i"
     * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     *
     * Note:
     * The input strings will not have extra blank.
     * The input strings will be given in the form of a+bi, where the integer a and b will both belong to
     * the range of [-100, 100]. And the output should be also in this form.
     */
    public String complexNumberMultiply(String a, String b) {
       String[] s1 = a.split("\\+|i");
       String[] s2 = b.split("\\+|i");
       int s1_r = Integer.parseInt(s1[0]);
       int s1_i = Integer.parseInt(s1[1]);
       int s2_r = Integer.parseInt(s2[0]);
       int s2_i = Integer.parseInt(s2[1]);
       return s1_r*s2_r+s1_i*s2_i + "+" + (s1_r*s2_i+s2_r*s1_i) + "i";
    }
    public String complexNumberMultiply1(String a, String b) {
        int idx1 = a.indexOf("+");
        int idx2 = b.indexOf("+");
        int x1 = Integer.parseInt(a.substring(0, idx1));
        int x2 = Integer.parseInt(a.substring(idx1+1, a.length()-1));
        int y1 = Integer.parseInt(b.substring(0, idx2));
        int y2 = Integer.parseInt(b.substring(idx2+1, b.length()-1));
        int x = x1*y1-x2*y2;
        int y = x1*y2+x2*y1;
        String res = x+"+"+y+"i";
        return res;
    }
}
