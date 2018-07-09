package com.company;
// Stack, Recursion

import java.util.Stack;

/**
 * 856. Score of Parentheses

 Given a balanced parentheses string S, compute the score of the string based on the following rule:

 () has score 1
 AB has score A + B, where A and B are balanced parentheses strings.
 (A) has score 2 * A, where A is a balanced parentheses string.


 Example 1:

 Input: "()"
 Output: 1
 Example 2:

 Input: "(())"
 Output: 2
 Example 3:

 Input: "()()"
 Output: 2
 Example 4:

 Input: "(()(()))"
 Output: 6


 Note:

 S is a balanced parentheses string, containing only ( and ).
 2 <= S.length <= 50
 */
public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        char[] s = S.toCharArray();
        int open=0;
        int start=0;
        int res=0;
        for (int i=0; i<s.length; ++i){
            if (s[i]=='(') open++;
            else open--;
            if (open==0){
                res += helper(s, start, i);
                start = i+1;
            }
        }
        return res;
    }
    private int helper(char[] ch, int s, int e){
        if (s+1==e) return 1;
        int open=0;
        int res=0;
        int start = s+1;
        for (int i=s; i<e; ++i){
            if (ch[i]=='(') open++;
            else open--;
            if (open==1){
                res += helper(ch, start, i);
                start = i+1;
            }
        }
        return 2*res;
    }

    public int scoreOfParentheses2(String S) {
        char[] s = S.toCharArray();
        int layer=0, res=0;
        for (int i=0; i<s.length; ++i){
            if (s[i]=='(') layer++;
            else layer--;
            if (s[i]=='(' && s[i+1]==')')
                res += 1<<(layer-1);
        }
        return res;
    }

    public int scoreOfParentheses3(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }


}
