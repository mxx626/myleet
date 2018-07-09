package List;
// LinkedList
public class RemoveLinkedListElements {
    /**
     * Remove all elements from a linked list of integers that have value val.

     Example:

     Input:  1->2->6->3->4->5->6, val = 6
     Output: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        while (p2!=null){
            if (p2.val==val){
                p2=p2.next;
                continue;
            }
            p1.next=p2;
            p1=p1.next;
            p2=p2.next;
        }
        if (p2==null) p1.next=null;
        return dummy.next;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
