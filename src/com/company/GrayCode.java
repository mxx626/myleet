package com.company;
// TAG: Backtracking

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.

     Given a non-negative integer n representing the total number of bits in the code, print the
     sequence of gray code. A gray code sequence must begin with 0.

     For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

     00 - 0
     01 - 1
     11 - 3
     10 - 2
     Note:
     For a given n, a gray code sequence is not uniquely defined.

     For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

     For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */
    private List<Integer> ret = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        ret.add(0);
        for (int i=0; i<n; ++i){
            int highBit = 1<<i;
            int size = ret.size();
            for (int j=size-1; j>=0; --j){
                int num = ret.get(j);
                num += highBit;
                ret.add(num);
            }
        }
        return ret;
    }
}
