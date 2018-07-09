package HashTable;
// TAG: Stack, LinkedList
import java.util.Stack;

public class AddTwoNumbersII {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contain a single
     * digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Follow up:
     What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

     Example:

     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     */
    private int carry=0;
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        int len1=getLen(l1);
        int len2=getLen(l2);
        ListNode res=null;
        if (len1>len2){
            res=helper(l1, l2, len1-len2);
        }
        else {
            res=helper(l2, l1, len2-len1);
        }
        if (carry!=0){
            ListNode dummy = new ListNode(carry);
            dummy.next=res;
            return dummy;
        }
        return res;
    }
    private int getLen(ListNode l1){
        int len=0;
        while (l1!=null){
            len++;
            l1=l1.next;
        }
        return len;
    }
    private ListNode helper(ListNode l1, ListNode l2, int diff){
        if (l1.next==null && l2.next==null) {
            ListNode res = new ListNode(l1.val+l2.val);
            carry=res.val/10;
            res.val=res.val%10;
            return res;
        }
        ListNode node = new ListNode(0);
        int sum=0;
        if (diff==0){
            node = helper(l1.next, l2.next, 0);
            sum += l1.val+l2.val+carry;
        }
        else {
            node = helper(l1.next, l2, diff-1);
            sum += carry+l1.val;
        }
        ListNode ret=new ListNode(sum%10);
        carry=sum/10;
        ret.next=node;
        return ret;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode dummy = new ListNode(0);
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1!=null){
            stack1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2);
            l2=l2.next;
        }
        int carry=0;
        ListNode next=null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ListNode cur = new ListNode(carry);
            if (!stack1.isEmpty()) cur.val += stack1.pop().val;
            if (!stack2.isEmpty()) cur.val += stack2.pop().val;
            carry=cur.val/10;
            cur.val = cur.val%10;
            cur.next=next;
            next=cur;
        }
        dummy.next=next;
        if (carry!=0) {
            dummy.val=carry;
            return dummy;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
