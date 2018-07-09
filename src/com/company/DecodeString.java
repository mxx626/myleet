package com.company;
// Stack, DFS
import java.util.Stack;

public class DecodeString {
    /**
     * Given an encoded string, return it's decoded string.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

     You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

     Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

     Examples:

     s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        String t = ""; int cnt = 0;
        for (int i=0; i<s.length(); ++i){
            if (arr[i]>='0' && arr[i]<='9'){
                cnt = 10 * cnt + arr[i]-'0';
            }
            else if (arr[i]=='['){
                count.push(cnt);
                stack.push(t);
                cnt = 0;
                t = "";
            }
            else if (arr[i]==']'){
                int k = count.peek();
                count.pop();
                String tmp = stack.peek();
                for (int j=0; j<k; ++j) {
                    tmp += t;
                }
                t = tmp;
                stack.pop();
            }
            else {
                t += arr[i];
            }
        }
        return stack.isEmpty() ? t : stack.peek();
    }
}
