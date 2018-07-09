package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a string representing an expression of fraction addition and subtraction, you need to
 * return the calculation result in string format. The final result should be irreducible fraction.
 * If your final result is an integer, say 2, you need to change it to the format of fraction
 * that has denominator 1. So in this case, 2 should be converted to 2/1.

 Example 1:
 Input:"-1/2+1/2"
 Output: "0/1"
 Example 2:
 Input:"-1/2+1/2+1/3"
 Output: "1/3"
 Example 3:
 Input:"1/3-1/2"
 Output: "-1/6"
 Example 4:
 Input:"5/3+1/3"
 Output: "2/1"
 Note:
 The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or
 the output is positive, then '+' will be omitted.
 The input only contains valid irreducible fractions, where the numerator and denominator of each
 fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is
 actually an integer in a fraction format defined above.
 The number of given fractions will be in the range [1,10].
 The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

 */
public class FractionAdditionandSubtraction {
    public String fractionAddition(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expression.length(); ++i){
            if (expression.charAt(i)=='-'){
                sb.append("+");
            }
            sb.append(expression.charAt(i));
        }
        int[] res = new int[2];
        Arrays.fill(res, Integer.MAX_VALUE);
        String[] exp = sb.toString().split("\\+");
        for (int i=0; i<exp.length; ++i){
            if (exp[i]==null || exp[i].length()==0) continue;
            if(res[0]==res[1] && res[1]==Integer.MAX_VALUE){
                res[1] = Integer.parseInt(exp[i].substring(exp[i].indexOf("/")+1));
                res[0] = Integer.parseInt(exp[i].substring(0, exp[i].indexOf("/")));
            }
            else {
                int nomi = Integer.parseInt(exp[i].substring(0, exp[i].indexOf("/")));
                int deno = Integer.parseInt(exp[i].substring(exp[i].indexOf("/")+1));
                res[0] = res[0] *deno + nomi * res[1];
                res[1] = res[1] * deno;
            }
        }
        if (res[0]==0) return "0/1";
        if (res[0]==1) return "1/"+res[1];
        if (res[1]==1 || res[0]%res[1]==0) return res[0]/res[1]+"/1";
        int g = simplify (res[0], res[1]);
        int resNume = res[0]/g;
        int resDeno = res[1]/g;
        if ((resNume*resDeno>0 && resNume<0) || (resNume*resDeno<0 && resNume>0)) return -resNume+"/"+(-resDeno);
        return resNume+"/"+resDeno;
    }
    private int simplify (int a, int b){
        while (b!=0){
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }

    public String fractionAddition2(String expression) {
        List<Character> sign = new ArrayList<>();
        if (expression.charAt(0)!='-'){
            sign.add('+');
        }
        for (int i=0; i<expression.length(); ++i){
            if (expression.charAt(i)=='+' || expression.charAt(i)=='-'){
                sign.add(expression.charAt(i));
            }
        }
        int prev_nominator=0, prev_denominator = 1, i=0;
        for (String sub : expression.split("(\\+)|(-)")){
            if (sub.length()>0){
                String[] num = sub.split("/");
                int nominator = Integer.parseInt(num[0]);
                int denominator = Integer.parseInt(num[1]);
                int g = Math.abs(gcd(denominator, prev_denominator));
                if (sign.get(i++)=='+'){
                    prev_nominator = nominator*prev_denominator/g + prev_nominator*denominator/g;
                }
                else{
                    prev_nominator = prev_nominator * denominator/g - nominator*prev_denominator/g;
                }
                prev_denominator = denominator*prev_denominator/g;
                g = Math.abs(gcd(prev_denominator, prev_nominator));
                prev_denominator/=g;
                prev_nominator/=g;
            }
        }
        return prev_nominator+"/"+prev_denominator;
    }
    private int gcd (int a, int b){
        while (b!=0){
            int t = b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
