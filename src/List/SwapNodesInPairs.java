package List;
/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the
 * values in the list, only nodes itself can be changed.
 *
 *  0->1->2->3->4->5
 *  p
 * **/
public class SwapNodesInPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next!=null && pre.next.next!=null){
            ListNode t = pre.next.next;
            pre.next.next = t.next;
            t.next = pre.next;
            pre.next = t;
            pre = t.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode first = head.next;
        head.next=swapPairs(first.next);
        first.next=head;
        return first;
    }
}
