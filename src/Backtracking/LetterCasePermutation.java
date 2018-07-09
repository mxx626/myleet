package Backtracking;
//Backtracking
import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

     Examples:
     Input: S = "a1b2"
     Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

     Input: S = "3z4"
     Output: ["3z4", "3Z4"]

     Input: S = "12345"
     Output: ["12345"]
     Note:

     S will be a string with length at most 12.
     S will consist only of letters or digits.

     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        char[] ch = S.toCharArray();
        helper(ch, 0, new StringBuilder());
        return res;
    }

    private void helper(char[] ch, int start, StringBuilder sb){
        if (sb.length()==ch.length){
            res.add(sb.toString());
            return;
        }
        for (int i=start; i<ch.length; ++i){
            if (!Character.isLetter(ch[i])){
                sb.append(ch[i]);
                helper(ch, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                char tmp = ch[i];
                tmp = Character.toLowerCase(tmp);
                sb.append(tmp);
                helper(ch, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
                tmp = Character.toUpperCase(tmp);
                sb.append(tmp);
                helper(ch, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
