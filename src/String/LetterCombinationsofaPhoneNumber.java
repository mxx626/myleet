package String;
// TAG: String, Backtracking.
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.

     A mapping of digit to letters (just like on the telephone buttons) is given below.



     Input:Digit string "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     Note:
     Although the above answer is in lexicographical order, your answer could be in any order you want.
     */
    private static final String[] db = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits==null || digits.length()==0) return res;
        StringBuilder sb = new StringBuilder();
        helper(digits.toCharArray(), 0, res, sb);
        return res;
    }
    private static void helper(char[] ch, int start, List<String> res, StringBuilder sb){
        if (start==ch.length){
            res.add(sb.toString());
            return;
        }
        //    else if (start>=ch.length) return;
        int number = (ch[start]-'0');
        for (int i=0; i<db[number-2].length(); ++i){
            sb.append(db[number-2].charAt(i));
            helper(ch, start+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
