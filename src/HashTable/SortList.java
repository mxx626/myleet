package HashTable;
// TAG: MergerSort, LinkedList
public class SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.

     Example 1:

     Input: 4->2->1->3
     Output: 1->2->3->4
     Example 2:

     Input: -1->5->3->4->0
     Output: -1->0->3->4->5

     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode dummy = new ListNode(0);
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        ListNode tmp2 = sortList(mid);
        ListNode tmp1 = sortList(head);
        dummy.next = merge(tmp1, tmp2);
        return dummy.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        while (l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if (l1.val>l2.val){
                    d.next = l2;
                    l2=l2.next;
                }
                else {
                    d.next = l1;
                    l1=l1.next;
                }
            }
            else if (l1!=null){
                d.next = l1;
                l1=l1.next;
            }
            else if (l2!=null) {
                d.next = l2;
                l2=l2.next;
            }
            d = d.next;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
