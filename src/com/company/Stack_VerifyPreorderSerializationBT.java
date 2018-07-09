package com.company;

import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.

            _9_
          /    \
         3     2
        / \   / \
       4   1  #  6
      / \ / \   / \
      # # # #   # #

 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find
 an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false
**/
public class Stack_VerifyPreorderSerializationBT {
    public boolean isValidSerialization(String preorder) {
        String[] strArr = preorder.split(",");
        int diff=1;
        for (String str : strArr){
            if (--diff<0) return false;
            if (!str.equals("#")) diff+=2; // for a tree

        }
        return diff==0 ? true : false;
    }









    public boolean isValidSerialization__WrongSolution(String preorder) {  //the solution is wrong because you do not know the actually length of subtree, if could be possible
        if (preorder==null || preorder.length()<3) return false;           // that the left tree is much more longer than the right subtree.
        String[] strArr = preorder.split(",");
        return DFS(strArr, 0, strArr.length-1);
    }

    public boolean DFS(String[] strings, int start, int end){
        if (start==end && strings[start]=="#") return true;
        if (strings[start]=="#" && !strings[start+1].isEmpty()) return false;
        return (DFS(strings, start+1, (end-start)/2+start)
                && DFS(strings, start+(end-start)/2+1, end))
                ||(DFS(strings, start+1, (end-start)/2+start+1)
                    &&DFS(strings, (end-start)/2+start+1, end));
    }
}

