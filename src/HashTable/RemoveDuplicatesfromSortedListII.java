package HashTable;
// TAG: LinkedList
public class RemoveDuplicatesfromSortedListII {
    /**
     * Given a sorted linked list, delete all nodes that have
     * duplicate numbers, leaving only distinct numbers from the original list.

     Example 1:

     Input: 1->2->3->3->4->4->5
     Output: 1->2->5
     Example 2:

     Input: 1->1->1->2->3
     Output: 2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode ptr = head;
        boolean flag = false;
        while (ptr!=null && ptr.next!=null){
            if (ptr.val==ptr.next.val){
                ptr=ptr.next;
                flag=true;
            }
            else {
                if (flag){
                    pre.next=ptr.next;
                    flag=false;
                }
                else {
                    pre=ptr;
                }
                ptr=ptr.next;
            }
        }
        if (flag) pre.next=null;
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
