package HashTable;
// TAG: LinkedList
public class OddEvenLinkedList {
    /**
     * Given a singly linked list, group all odd nodes together
     * followed by the even nodes. Please note here we are talking
     * about the node number and not the value in the nodes.

     You should try to do it in place. The program should run in
     O(1) space complexity and O(nodes) time complexity.

     Example:
     Given 1->2->3->4->5->NULL,
     return 1->3->5->2->4->NULL.

     Note:
     The relative order inside both the even and odd groups should remain as it was in the input.
     The first node is considered odd, the second node even and so on ...
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode secHead = even;
        dummy.next=head;
        while (odd!=null && even!=null){
            pre = odd;
            odd.next = even.next;
            odd = odd.next;
            if (odd!=null){
                even.next=odd.next;
                even=even.next;
            }
        }
        if (even==null) odd.next=secHead;
        else {
            pre.next=secHead;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
