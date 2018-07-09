package List;
// LinkedList
import java.util.Stack;

public class PalindromeLinkedList {
    /**
     * Given a singly linked list, determine if it is a palindrome.

     Example 1:

     Input: 1->2
     Output: false
     Example 2:

     Input: 1->2->2->1
     Output: true
     Follow up:
     Could you do it in O(n) time and O(1) space?
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;
        Stack<ListNode> s = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            s.push(cur);
            cur=cur.next;
        }
        while (!s.isEmpty()){
            if (s.pop().val!=head.val) return false;
            head=head.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
