package Trie;

/**
 * 421. Maximum XOR of Two Numbers in an Array

 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums){
            TrieNode cur = root;
            for (int i=31; i>=0; --i){
                int curBit = (num >>> i) & 1;
                if (cur.kids[curBit]==null){
                    cur.kids[curBit] = new TrieNode();
                }
                cur = cur.kids[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            TrieNode cur = root;
            int curSum = 0;
            for (int i=31; i>=0; --i){
                int curBit = (num >>> i) & 1;
                if (cur.kids[curBit^1]!=null){
                    curSum |= 1<<i;
                    cur = cur.kids[curBit^1];
                }
                else {
                    cur = cur.kids[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
    class TrieNode{
        TrieNode[] kids;
        public TrieNode(){
            kids = new TrieNode[2];
        }
    }
}
