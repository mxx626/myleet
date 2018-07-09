package com.company;
// Backtracking
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {
    List<Integer> ret = new ArrayList<>();

    /**
     * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

     Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

     0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
     F.length >= 3;
     and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
     Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

     Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

     Example 1:
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        if (S==null || S.length()<3) return ret;
        LinkedList<Integer> res = new LinkedList<>();
        helper(S, res, 0);
        return ret;
    }
    private void helper(String s, LinkedList<Integer> res, int start){
        if (start==s.length() && res.size()>2){
            ret = new LinkedList<>(res);
            return;
        }
        else if (start>=s.length()) return;
        for (int i=start; i<s.length(); ++i){
            if (s.charAt(start)=='0' && i!=start) break;
            long tmp = Long.parseLong(s.substring(start, i+1));
            if (tmp>Integer.MAX_VALUE) break;
            int num = Integer.parseInt(s.substring(start, i+1));
            if (res.size()<2 || (res.get(res.size()-1)+res.get(res.size()-2)==num)) {
                res.offer(num);
                helper(s, res, i+1);
                res.pollLast();
            }
            else if (res.get(res.size()-1)+res.get(res.size()-2)<num) break;
        }
    }
}
