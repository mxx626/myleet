import java.util.Random;
// Resevoir Sampling
/**
 * 382. Linked List Random Node

 Given a singly linked list, return a random node's value from the linked list.
 Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you?
 Could you solve this efficiently without using extra space?

 Example:

 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = head;
        ListNode cur = head;
        int size = 1;
        while (cur!=null){
            if (rand.nextInt(size)==0){
                res = cur;
            }
            size++;
            cur = cur.next;
        }
        return res.val;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

}
