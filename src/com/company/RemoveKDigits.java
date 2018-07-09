package com.company;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
ote:

 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.

 Example 1:
 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 Example 2:
 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

 Example 3:
 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 1432219
 1
 14  2   k=3
 13  3   k=2
 12  4   k=1
 12  5   k=0
 1219
 * **/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num==null || num.length()<=k ) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int idx=1, len=num.length();
        char[] arr = num.toCharArray();
        st.push(arr[0]);
        while (!st.isEmpty() && idx < len){
            while (!st.isEmpty()){
                char tmp = st.peek();
                if (tmp>arr[idx] && k!=0){
                    st.pop();
                    k--;
                }
                else break;
            }
            while (idx<len && arr[idx]=='0' && st.isEmpty()){
                idx++;
            }
            if (idx==len) break;
            st.push(arr[idx++]);
        }
        while (k!=0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        else {
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
        }
        return sb.reverse().toString();
    }

    public String removeKdigits1(String num, int k) {
        int len = num.length()-k;
        if (len<=0) return "0";
        char[] res = new char[num.length()];
        int top=0;
        for (char c : num.toCharArray()){
            while (k>0 && top>0 && res[top-1]>c){
                k--; top--;
            }
            res[top++]=c;
        }
        int firstZero=0;
        while (firstZero<len && res[firstZero]=='0') firstZero++;
        return firstZero==len ? "0" : new String(res, firstZero, len-firstZero);
    }
}
