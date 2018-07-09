package String;
// TAG: String, Math
public class ComplexNumberMultiplication {
    /**
     * Given two strings representing two complex numbers.

     You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

     Example 1:
     Input: "1+1i", "1+1i"
     Output: "0+2i"
     Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     Example 2:
     Input: "1+-1i", "1+-1i"
     Output: "0+-2i"
     Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     Note:

     The input strings will not have extra blank.
     The input strings will be given in the form of a+bi, where the integer a and b will both belong
     to the range of [-100, 100]. And the output should be also in this form.
     * @param a
     * @param b
     * @return
     */
    public String complexNumberMultiply(String a, String b) {
        String[] s1 = a.split("\\+");
        String[] s2 = b.split("\\+");
        int a1=Integer.parseInt(s1[0].substring(0, s1[0].length()));
        int a2=Integer.parseInt(s1[1].substring(0, s1[1].length()-1));
        int b1=Integer.parseInt(s2[0].substring(0, s2[0].length()));
        int b2=Integer.parseInt(s2[1].substring(0, s2[1].length()-1));
        return a1*b1+a2*b2*(-1)+"+"+(a1*b2+a2*b1)+"i";

    }
}
