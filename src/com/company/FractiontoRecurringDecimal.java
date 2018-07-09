package com.company;
// TAG: HashTable, Math
import java.util.HashMap;

public class FractiontoRecurringDecimal {
    StringBuilder c = new StringBuilder();
    HashMap<Long, Integer> map = new HashMap<>();

    /**
     * Given two integers representing the numerator and denominator
     * of a fraction, return the fraction in string format.

     If the fractional part is repeating, enclose the repeating part in parentheses.

     For example,

     Given numerator = 1, denominator = 2, return "0.5".
     Given numerator = 2, denominator = 1, return "2".
     Given numerator = 2, denominator = 3, return "0.(6)".
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        if (numerator==denominator) return "1";
        String sign = ((numerator > 0) ^ (denominator > 0)) ? "-" : "";
        long n = Math.abs((long)numerator);
        long m = Math.abs((long)denominator);
        c.append(sign+n/m);
        n %= m;
        if (n==0) return c.toString();
        c.append(".");
        map.put(n, c.length());
        helper(n, m);
        return c.toString();
    }
    private void helper(long n, long m){
        if (n==0) return;
        n *= 10;
        c.append(n/m);
        n = n%m;
        if (map.containsKey(n)){
            int idx = map.get(n);
            c.insert(idx, '(');
            c.append(')');
        }
        else{
            map.put(n, c.length());
            helper(n, m);
        }
        return;
    }
}
