package String;
// String
public class JudgeRouteCircle {
    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
     * judge if this robot makes a circle, which means it moves back to the original place.

     The move sequence is represented by a string. And each move is represent by a character.
     The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

     Example 1:
     Input: "UD"
     Output: true
     Example 2:
     Input: "LL"
     Output: false
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        byte[] bytes = new byte[128];
        for(char i : moves.toCharArray()){
            bytes[i]++;
        }

        return bytes['R'] == bytes['L'] && bytes['U'] == bytes['D'];
    }
}
