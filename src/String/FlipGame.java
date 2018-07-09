package String;
// String
import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    /**
     * You are playing the following Flip Game with your friend: Given a string that
     * contains only these two characters: + and -, you and your friend take turns to
     * flip two consecutive "++" into "--". The game ends when a person can no longer
     * make a move and therefore the other person will be the winner.

     Write a function to compute all possible states of the string after one valid move.

     Example:

     Input: s = "++++"
     Output:
     [
     "--++",
     "+--+",
     "++--"
     ]
     Note: If there is no valid move, return an empty list [].
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (int i=0; i<ch.length-1; ++i){
            if (ch[i]=='+' && ch[i+1]=='+'){
                ch[i]='-'; ch[i+1]='-';
                res.add(new String(ch));
                ch[i]='+'; ch[i+1]='+';
            }
        }
        return res;
    }
}
