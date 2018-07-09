package List;
// LinkedList
/**
 * 25. Reverse Nodes in k-Group

 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number
 of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesink_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            ListNode start = cur;
            for (int i=1; i<k; i++){
                cur=cur.next;
                if (cur==null) return dummy.next;
            }
            ListNode newHead = cur.next;
            cur.next = null;
            ListNode end = pre.next;
            pre.next = reverse(start);
            pre = end;
            cur = newHead;
            pre.next = cur;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode tmp = head.next;
        ListNode next = reverse(tmp);
        tmp.next = head;
        head.next = null;
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
