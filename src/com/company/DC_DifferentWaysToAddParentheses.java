package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to
 * group numbers and operators. The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 *
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * **/
public class DC_DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<input.length(); ++i){
            char tmp = input.charAt(i);
            if (tmp=='+'||tmp=='-'||tmp=='*'){
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for (Integer num1 : part1){
                    for (Integer num2 : part2){
                        int c=0;
                        switch (tmp){
                            case '+': c=num1+num2; break;
                            case '-': c=num1-num2; break;
                            case '*': c=num1*num2; break;
                        }
                        res.add(c);
                    }
                }

            }
        }
        if (res.size()==0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
