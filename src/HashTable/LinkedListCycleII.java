package HashTable;
// TAG: Two Pointer, LinkedList
public class LinkedListCycleII {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

     Note: Do not modify the linked list.

     Follow up:
     Can you solve it without using extra space?
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) break;
        }
        if (fast==null || fast.next==null) return null;
        //     System.out.println(fast.val);
        ListNode pointer = head;
        while (pointer!=slow){
            pointer=pointer.next;
            slow=slow.next;
            if (pointer==slow) return pointer;
        }
        return pointer;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
