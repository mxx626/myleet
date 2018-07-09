package com.company;
// DP, Memo
import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
    /**
     * You are playing the following Flip Game with your friend: Given a string that contains
     * only these two characters: + and -, you and your friend take turns to flip two consecutive
     * "++" into "--". The game ends when a person can no longer make a move and therefore the
     * other person will be the winner.

     Write a function to determine if the starting player can guarantee a win.

     Example:

     Input: s = "++++"
     Output: true
     Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
     Follow up:
     Derive your algorithm's runtime complexity.


     * @param s
     * @return
     */
    public boolean canWin(String s) {
        char[] ch = s.toCharArray();
        Map<String, Boolean> map = new HashMap<>();
        return helper(ch, map);
    }
    private boolean helper(char[] arr, Map<String, Boolean> map){
        String str = new String(arr);
        if (map.containsKey(str)) return map.get(str);
        boolean flag = false;
        for (int i=0; i<arr.length-1; i=i+1){
            if (arr[i]=='+' && arr[i+1]=='+'){
                arr[i]='-'; arr[i+1]='-';
                if (!helper(arr,map)){
                    flag=true;
                }
                arr[i]='+'; arr[i+1]='+';
            }
        }
        map.put(str, flag);
        return flag;
    }
}
