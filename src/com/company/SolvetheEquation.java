package com.company;
// Math
/**
 * 640. Solve the Equation


 Solve a given equation and return the value of x in the form of string "x=#value".
 The equation contains only '+', '-' operation, the variable x and its coefficient.

 If there is no solution for the equation, return "No solution".

 If there are infinite solutions for the equation, return "Infinite solutions".

 If there is exactly one solution for the equation, we ensure that the value of x is an integer.

 Example 1:
 Input: "x+5-3+x=6+x-2"
 Output: "x=2"
 Example 2:
 Input: "x=x"
 Output: "Infinite solutions"
 Example 3:
 Input: "2x=x"
 Output: "x=0"
 Example 4:
 Input: "2x+3x-6x=x+2"
 Output: "x=-1"
 Example 5:
 Input: "x=x+2"
 Output: "No solution"
 */
public class SolvetheEquation {
    public String solveEquation(String equation) {
        int x_coe = 0;
        int constant = 0;
        int sign = 1;
        int l = 0;
        for (int i=0; i<equation.length(); ++i){
            char cur = equation.charAt(i);
            if (cur=='+' || cur=='-'){
                if (i>l) constant += sign*Integer.parseInt(equation.substring(l, i));
                l=i;
            }
            else if (cur=='x'){
                if (l==i || equation.charAt(i-1)=='+') x_coe += sign;
                else if (equation.charAt(i-1)=='-') x_coe -= sign;
                else x_coe += Integer.parseInt(equation.substring(l, i))*sign;
                l=i+1;
            }
            else if (cur=='='){
                if (i>l) constant += sign*Integer.parseInt(equation.substring(l, i));
                sign = -1;
                l=i+1;
            }
        }
        if (l<equation.length()) constant += sign*Integer.parseInt(equation.substring(l));
        if (x_coe==0 && constant!=0) return "No solution";
        if (x_coe==0 && constant==0) return "Infinite solutions";
        return "x="+(-constant/x_coe);
    }
}
