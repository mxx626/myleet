package HashTable;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null && cur.val<x){
            pre = cur;
            cur = cur.next;
        }
        if (cur==null) return head;
        while (cur!=null && cur.next!=null){
            if (cur.next.val>=x){
                cur=cur.next;
            }
            else {
                ListNode node = cur.next;
                cur.next = node.next;
                node.next=pre.next;
                pre.next=node;
                pre=pre.next;
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
