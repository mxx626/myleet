package HashTable;
// TAG: Insertion Sort
public class InsertionSortList {
    /**
     * Sort a linked list using insertion sort.


     A graphical example of insertion sort. The partial sorted list (black)
     initially contains only the first element in the list.
     With each iteration one element (red) is removed from the input data
     and inserted in-place into the sorted list


     Algorithm of Insertion Sort:

     Insertion sort iterates, consuming one input element each repetition,
     and growing a sorted output list.
     At each iteration, insertion sort removes one element from the input
     data, finds the location it belongs within the sorted list, and inserts it there.
     It repeats until no input elements remain.

     Example 1:

     Input: 4->2->1->3
     Output: 1->2->3->4
     Example 2:

     Input: -1->5->3->4->0
     Output: -1->0->3->4->5
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null && cur.next!=null){
            if (cur.val<=cur.next.val){
                cur=cur.next;
            }
            else {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                pre = dummy;
                while (pre.next.val<tmp.val){
                    pre=pre.next;
                }
                tmp.next=pre.next;
                pre.next=tmp;
            }
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
