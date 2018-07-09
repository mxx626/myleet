package HashTable;
// TAG: LinkedList
public class SwapNodesinPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.

     Example:

     Given 1->2->3->4, you should return the list as 2->1->4->3.
     Note:

     Your algorithm should use only constant extra space.
     You may not modify the values in the list's nodes, only nodes itself may be changed.

     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre1, pre2;
        ListNode prevEnd=dummy;
        while (second!=null && second.next!=null){
            pre1 = second.next;
            pre2 = pre1.next;
            prevEnd.next=second;
            second.next=first;
            prevEnd = first;
            prevEnd.next=pre1;
            first=pre1;
            second = pre2;
        }
        if (second!=null){
            prevEnd.next=second;
            second.next=first;
            first.next=null;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
