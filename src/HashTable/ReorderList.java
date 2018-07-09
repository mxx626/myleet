package HashTable;
// TAG: LinkedList, Two Pointer
public class ReorderList {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

     You may not modify the values in the list's nodes, only nodes itself may be changed.

     Example 1:

     Given 1->2->3->4, reorder it to 1->4->2->3.
     Example 2:

     Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode first=head;
        ListNode second=head;
        while (second.next!=null && second.next.next!=null){
            first=first.next;
            second = second.next.next;
        }
        ListNode mid = first;
        ListNode next = mid.next;
        while (next.next!=null){
            ListNode cur = next.next;
            next.next = cur.next;
            cur.next=mid.next;
            mid.next=cur;
        }
        first=head;
        ListNode secondHead = mid.next;
        mid.next=null;
        while (secondHead!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHead.next;
            first.next=secondHead;
            secondHead.next=tmp1;
            first=tmp1;
            secondHead=tmp2;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
