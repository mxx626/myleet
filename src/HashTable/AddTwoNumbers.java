package HashTable;
// TAG: LinkedList
public class AddTwoNumbers {
    /**
     *You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their
     * nodes contain a single digit. Add the two numbers and return it as
     * a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return dummy.next;
    }




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head = new ListNode(0);
        head.next=l1;
        ListNode pre = head;
        while (l1!=null || l2!=null){
            if (l1!=null && l2!=null){
                int val = l1.val+l2.val+carry;
                carry = val/10;
                l1.val = val%10;
                pre=l1;
                l1=l1.next;
                l2=l2.next;
            }
            else if (l1!=null){
                while (l1!=null){
                    int val = l1.val+carry;
                    carry = val/10;
                    l1.val=val%10;
                    pre=l1;
                    l1=l1.next;
                }
            }
            else {
                pre.next=l2;
                while (l2!=null){
                    int val = l2.val+carry;
                    carry=val/10;
                    l2.val=val%10;
                    pre=l2;
                    l2=l2.next;
                }
            }
        }
        if (carry!=0) {
            pre.next = new ListNode(carry);
        }
        return head.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
