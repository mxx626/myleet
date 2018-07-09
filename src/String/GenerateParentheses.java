package String;
// TAG: String, Backtracking
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, res, sb);
        return res;
    }
    private void helper(int n, int left, int right, List<String> res, StringBuilder sb){
        if (left==right && left==n){
            res.add(sb.toString());
            return;
        }
        else if (left>n||right>n) return;
        helper(n, left+1, right, res, sb.append("("));
        sb.deleteCharAt(sb.length()-1);
        if (right<left) {
            helper(n, left, right + 1, res, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
