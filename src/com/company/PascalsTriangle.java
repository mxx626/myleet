package com.company;
// DP, Math
import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle

 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 5
 Output:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows==0) return res;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i=1; i<numRows; ++i){
            List<Integer> tmp = new ArrayList<>();
            for (int j=0; j<=i; ++j){
                if (j==0 || j==i) tmp.add(1);
                else {
                    tmp.add(list.get(j)+list.get(j-1));
                }
            }
            res.add(tmp);
            list = tmp;
        }
        return res;
    }
}
