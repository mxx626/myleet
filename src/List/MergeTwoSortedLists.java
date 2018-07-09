package List;
// LinkedList
/**
 * 21. Merge Two Sorted Lists

 Merge two sorted linked lists and return it as a new list. The new list
 should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            if (l1.val>l2.val){
                dummy.next = new ListNode(l2.val);
                l2=l2.next;
            }
            else {
                dummy.next = new ListNode(l1.val);
                l1=l1.next;
            }
            dummy=dummy.next;
        }
        if (l1!=null) {
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        return cur.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
