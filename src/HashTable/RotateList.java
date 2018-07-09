package HashTable;
// TAG: LinkedList, Two Pointer
public class RotateList {
    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.

     Example 1:

     Input: 1->2->3->4->5->NULL, k = 2
     Output: 4->5->1->2->3->NULL
     Explanation:
     rotate 1 steps to the right: 5->1->2->3->4->NULL
     rotate 2 steps to the right: 4->5->1->2->3->NULL
     Example 2:

     Input: 0->1->2->NULL, k = 4
     Output: 2->0->1->NULL
     Explanation:
     rotate 1 steps to the right: 2->0->1->NULL
     rotate 2 steps to the right: 1->2->0->NULL
     rotate 3 steps to the right: 0->1->2->NULL
     rotate 4 steps to the right: 2->0->1->NULL

     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        int len = getLen(head);
        k=k%len;
        ListNode p1 = head;
        ListNode p2 = head;
        while (k!=0){
            p2=p2.next;
            k--;
        }
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=head;
        ListNode res = p1.next;
        p1.next=null;
        return res;
    }
    private int getLen(ListNode head){
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
