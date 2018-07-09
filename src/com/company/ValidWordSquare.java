package com.company;
// String
import java.util.List;

public class ValidWordSquare {
    /**
     * Given a sequence of words, check whether it forms a valid word square.

     A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

     Note:
     The number of words given is at least 1 and does not exceed 500.
     Word length will be at least 1 and does not exceed 500.
     Each word contains only lowercase English alphabet a-z.
     Example 1:

     Input:
     [
     "abcd",
     "bnrt",
     "crmy",
     "dtye"
     ]

     Output:
     true

     Explanation:
     The first row and first column both read "abcd".
     The second row and second column both read "bnrt".
     The third row and third column both read "crmy".
     The fourth row and fourth column both read "dtye".

     Therefore, it is a valid word square.
     Example 2:

     Input:
     [
     "abcd",
     "bnrt",
     "crm",
     "dt"
     ]

     Output:
     true

     Explanation:
     The first row and first column both read "abcd".
     The second row and second column both read "bnrt".
     The third row and third column both read "crm".
     The fourth row and fourth column both read "dt".

     Therefore, it is a valid word square.
     Example 3:

     Input:
     [
     "ball",
     "area",
     "read",
     "lady"
     ]

     Output:
     false

     Explanation:
     The third row reads "read" while the third column reads "lead".

     Therefore, it is NOT a valid word square.
     * @param words
     * @return
     */
    public boolean validWordSquare(List<String> words) {
        if (words==null || words.size()==0) return true;
        for (int i=0; i<words.size(); ++i){
            String row = words.get(i);
            String col = generateCol(words, i);
            if (!row.equals(col)) return false;
        }
        return true;
    }
    private String generateCol (List<String> words, int idx){
        StringBuilder sb = new StringBuilder();
        for (String word : words){
            if (idx>word.length()-1) continue;
            sb.append(word.charAt(idx));
        }
        return sb.toString();
    }

    public boolean validWordSquare2(List<String> words) {
        if (words==null || words.size()==0) return true;
        char[][] arr = new char[words.size()][];
        for (int i=0; i<words.size(); ++i){
            arr[i] = words.get(i).toCharArray();
        }
        for (int i=0; i<arr.length; ++i){
            for (int j=0; j<arr[i].length; ++j){
                if (j>=words.size() || i>= arr[j].length || arr[i][j]!=arr[j][i])
                    return false;
            }
        }
        return true;
    }
}
