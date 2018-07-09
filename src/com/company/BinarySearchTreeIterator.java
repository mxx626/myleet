package com.company;

import java.util.Stack;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private int _top=0;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return -1;
        int res = stack.peek().val;
        TreeNode cur = stack.pop();
        if (cur.right!=null){
            while (cur.right!=null){
                stack.push(cur.right);
                cur.right = cur.right.left;
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class BST_Iter {
        private TreeNode cur;
        private TreeNode pre;
        public BST_Iter(TreeNode root) {
            pre=null;
            cur=root;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return cur!=null;
        }

        /** @return the next smallest number */
        public int next() {
            int res=0;
            while (cur!=null){
                if (cur.left==null){
                    res = cur.val;
                    cur = cur.right;
                    break;
                }
                else {
                    pre = cur.left;
                    while (pre.right!=null && pre.right!=cur) pre=pre.right;
                    if (pre.right==null){
                        pre.right=cur;
                        cur = cur.left;
                    }
                    else {
                        pre.right=null;
                        res = cur.val;
                        cur = cur.right;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
