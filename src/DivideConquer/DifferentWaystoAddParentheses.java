package DivideConquer;
// Divide Conquer
import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    /**
     * Given a string of numbers and operators, return all possible results from computing all the
     * different possible ways to group numbers and operators. The valid operators are +, - and *.


     Example 1
     Input: "2-1-1".

     ((2-1)-1) = 0
     (2-(1-1)) = 2
     Output: [0, 2]


     Example 2
     Input: "2*3-4*5"

     (2*(3-(4*5))) = -34
     ((2*3)-(4*5)) = -14
     ((2*(3-4))*5) = -10
     (2*((3-4)*5)) = -10
     (((2*3)-4)*5) = 10
     Output: [-34, -14, -10, -10, 10]
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<input.length(); ++i)
        {
            char c = input.charAt(i);
            if (c=='-'||c=='+'||c=='*')
            {
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> l = diffWaysToCompute(left);
                List<Integer> r = diffWaysToCompute(right);
                for (int x : l)
                {
                    for(int y : r)
                    {
                        if (c=='-') res.add(x-y);
                        else if (c=='+') res.add(x+y);
                        else if (c=='*') res.add(x*y);
                    }
                }
            }

        }
        if (res.size()==0) res.add(Integer.parseInt(input));
        return res;
    }
}
