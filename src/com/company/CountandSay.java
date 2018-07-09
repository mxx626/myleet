package com.company;
// String
public class CountandSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth term of the count-and-say sequence.

     Note: Each term of the sequence of integers will be represented as a string.

     Example 1:

     Input: 1
     Output: "1"
     Example 2:

     Input: 4
     Output: "1211"

     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n==1) return "1";
        if (n==2) return "11";
        String pre = "11";
        for (int i=3; i<=n; ++i){
            String tmp = pre;
            pre = generate(tmp);
        }
        return pre;
    }
    private String generate(String pre){
        StringBuilder sb = new StringBuilder();
        char[] ch = pre.toCharArray();
        int ptr = 0;
        int count = 0;
        char preChar = ch[0];
        while (ptr<ch.length){
            char cur = ch[ptr++];
            if (cur!=preChar){
                sb.append(count).append(preChar);
                count=1;
                preChar = cur;
            }
            else count++;
        }
        sb.append(count).append(preChar);
        return sb.toString();
    }
}
