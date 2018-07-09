package HashTable;
// TAG: LinkedList, Two Pointers
public class RemoveNthNodeFromEndofList {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.

     Example:

     Given linked list: 1->2->3->4->5, and n = 2.

     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:

     Given n will always be valid.

     Follow up:

     Could you do this in one pass?
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode first=dummy;
        ListNode second = dummy;
        dummy.next=head;
        while (n!=0){
            second=second.next;
            n--;
        }
        while (second.next!=null){
            first=first.next;
            second=second.next;
        }
        first.next=first.next.next;
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
