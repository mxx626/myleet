package com.company;
// Stack, String
import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     An input string is valid if:

     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.
     Note that an empty string is also considered valid.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c=='{') stack.push('}');
            else if (c=='(') stack.push(')');
            else if (c=='[') stack.push(']');
            else if (stack.isEmpty() || c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
