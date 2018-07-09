package HashTable;
// TAG: LinkedList
public class ReverseLinkedListII {
    /**
     * Reverse a linked list from position m to n. Do it in one-pass.

     Note: 1 ≤ m ≤ n ≤ length of list.

     Example:

     Input: 1->2->3->4->5->NULL, m = 2, n = 4
     Output: 1->4->3->2->5->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = head;
        ListNode pre = dummy;
        while (n!=1 && m!=1){
            pre=pre.next;
            first=first.next;
            m--;
            n--;
        }
        // System.out.println(first.val);
        // System.out.println(pre.val);
        while (n!=1){
            ListNode cur = first.next;
            first.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            n--;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
