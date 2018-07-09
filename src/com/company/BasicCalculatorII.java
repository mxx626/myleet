package com.company;
// TAG: String
import java.util.Stack;

public class BasicCalculatorII {
    /**
     *
     Implement a basic calculator to evaluate a simple expression string.

     The expression string contains only non-negative integers, +, -, *, / operators and
     empty spaces . The integer division should truncate toward zero.

     You may assume that the given expression is always valid.

     Some examples:
     "3+2*2" = 7
     " 3/2 " = 1
     " 3+5 / 2 " = 5
     Note: Do not use the eval built-in library function.
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int res=0;
        char sign='+';
        int num=0;
        for (int i=0; i<ch.length; ++i){
            if (ch[i]>='0'&&ch[i]<='9'){
                num = ch[i]-'0';
                while (i+1<ch.length && ch[i+1]>='0' && ch[i+1]<='9'){
                    num = num*10 + ch[i+1] - '0';
                    i++;
                }
            }
            if (((ch[i]<'0'||ch[i]>'0') && (ch[i]!=' '))|| i==ch.length-1){
                if (sign=='+') stack.push(num);
                if (sign=='-') stack.push(-num);
                if (sign=='*') stack.push(stack.pop()*num);
                if (sign=='/') stack.push(stack.pop()/num);
                sign=ch[i];
                num=0;
            }
        }
        for (int i : stack){
            res += i;
        }
        return res;
    }

    public int calculate2(String s) {
        s = s.trim().replaceAll(" +", "");
        char[] ch = s.toCharArray();
        int res=0;
        char sign='+';
        int preVal=0;
        int i=0;
        while (i<ch.length){
            int cur=0;
            while (i<ch.length && ch[i]>='0' && ch[i]<='9'){
                cur = cur*10 + ch[i]-'0';
                i++;
            }
            if (sign=='+'){
                res += preVal;
                preVal=cur;
            }
            if (sign=='-'){
                res += preVal;
                preVal=-cur;
            }
            if (sign=='*'){
                preVal = preVal*cur;
            }
            if (sign=='/'){
                preVal = preVal/cur;
            }
            if(i<ch.length){
                sign=ch[i];
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
