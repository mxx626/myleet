package String;
// TAG: String, Tree, Recuision
import java.util.Stack;

public class ConstructBinaryTreefromString {
    /**
     *You need to construct a binary tree from a string consisting of parenthesis and integers.

     The whole input represents a binary tree. It contains an integer followed by zero, one or
     two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis
     contains a child binary tree with the same structure.

     You always start to construct the left child node of the parent first if it exists.

     Example:
     Input: "4(2(3)(1))(6(5))"
     Output: return the tree root node representing the following tree:

     4
     /   \
     2     6
     / \   /
     3   1 5
     Note:
     There will only be '(', ')', '-' and '0' ~ '9' in the input string.
     An empty tree is represented by "" instead of "()".

     * @param s
     * @return
     */
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if (c==')') stack.pop();
            else if ((c>='0' && c<='9') || c=='-'){
                int start=i;
                while (i+1<s.length() && (s.charAt(i+1)>='0' && s.charAt(i+1)<='9')) i++;
                TreeNode cur = new TreeNode(Integer.valueOf(s.substring(start, i+1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if (parent.left!=null) parent.right=cur;
                    else parent.left=cur;
                }
                stack.push(cur);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode str2tree2(String s) {
        if (s.length()==0) return null;
        int i=0, j=0;
        while (j<s.length() && ((s.charAt(j)>='0'&&s.charAt(j)<='9') || s.charAt(j)=='-')) j++;
        TreeNode root = new TreeNode (Integer.valueOf(s.substring(i, j)));
        if (j<s.length()){
            int k=j, count=1;
            while (j+1<s.length() && count!=0){
                j++;
                if (s.charAt(j)=='(') count++;
                if (s.charAt(j)==')') count--;
            }
            root.left = str2tree(s.substring(k+1, j));
        }
        j++;
        if (j<s.length()){
            root.right = str2tree(s.substring(j+1, s.length()-1));
        }
        return root;
    }
}
