package com.company;

/**
 * 514. Freedom Trail
 DescriptionHintsSubmissionsDiscussSolution
 In the video game Fallout 4, the quest "Road to Freedom" requires players to reach
 a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific
 keyword in order to open the door.

 Given a string ring, which represents the code engraved on the outer ring and another
 string key, which represents the keyword needs to be spelled. You need to find the
 minimum number of steps in order to spell all the characters in the keyword.

 Initially, the first character of the ring is aligned at 12:00 direction. You need to
 spell all the characters in the string key one by one by rotating the ring clockwise
 or anticlockwise to make each character of the string key aligned at 12:00 direction
 and then by pressing the center button.
 At the stage of rotating the ring to spell the key character key[i]:
 You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step.
 The final purpose of the rotation is to align one of the string ring's characters at
 the 12:00 direction, where this character must equal to the character key[i].
 If the character key[i] has been aligned at the 12:00 direction, you need to press the
 center button to spell, which also counts as 1 step. After the pressing, you could begin
 to spell the next character in the key (next stage), otherwise, you've finished all the
 spelling.
 Example:


 Input: ring = "godding", key = "gd"
 Output: 4
 Explanation:
 For the first key character 'g', since it is already in place, we just need 1 step to
 spell this character.
 For the second key character 'd', we need to rotate the ring "godding" anticlockwise
 by two steps to make it become "ddinggo".
 Also, we need 1 more step for spelling.
 So the final output is 4.
 Note:
 Length of both ring and key will be in range 1 to 100.
 There are only lowercase letters in both strings and might be some duplcate characters in both strings.
 It's guaranteed that string key could always be spelled by rotating the string ring.
 */
public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        return dfs(ring.toCharArray(), key.toCharArray(), 0, 0, new int[ring.length()][key.length()]);
    }
    private int dfs(char[] ring, char[] key, int index, int ridx, int[][] memo){
        if (index==key.length) return 0;
        if (memo[ridx][index]!=0) return memo[ridx][index];
        int min = Integer.MAX_VALUE;
        for (int i=0; i<ring.length; ++i){
            if (ring[i]==key[index]){
                int diff = Math.abs(i-ridx);
                int dist = 1+ Math.min(diff, ring.length-diff)+dfs(ring, key, index+1, i, memo);
                min = Math.min(dist, min);
            }
        }
        memo[ridx][index]=min;
        return min;
    }


    public int findRotateSteps2(String ring, String key) {
        int klen = key.length();
        int rlen = ring.length();
        int[][] dp = new int[klen+1][rlen];
        for (int i=klen-1; i>=0; --i){
            for (int j=0; j<rlen; ++j){
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=0; k<rlen; ++k){
                    if (ring.charAt(k)==key.charAt(i)){
                        int diff = Math.abs(j-k);
                        int step = Math.min(diff, rlen-diff);
                        dp[i][j] = Math.min(dp[i][j], step+dp[i+1][k]);
                    }
                }
            }
        }
        return dp[0][0]+klen;
    }
}
