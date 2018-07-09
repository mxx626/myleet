package HashTable;
// TAG: HashTable, LinkedList
import java.util.HashMap;

public class CopyListwithRandomPointer {
    /**
     * A linked list is given such that each node contains an additional random
     * pointer which could point to any node in the list or null.

     Return a deep copy of the list.
     * @param head
     * @return
     */
    public RandomListNode copyRandomList3(RandomListNode head) {
        if (head==null) return null;
        RandomListNode node = head;
        while (node!=null){
            RandomListNode copy = new RandomListNode(node.label);
            copy.next=node.next;
            node.next=copy;
            node=node.next.next;
        }
        node=head;
        while(node!=null){
            if (node.random!=null){
                node.next.random = node.random.next;
            }
            node=node.next.next;
        }
        RandomListNode newHead = head.next;
        node=head;
        while (node!=null){
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if (newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            node = node.next;
        }
        return newHead;
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode node1 = head;
        while(node1!=null){
            map.put(node1, new RandomListNode(node1.label));
            node1=node1.next;
        }
        RandomListNode node = head;
        while (node!=null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node=node.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head==null) return null;
        RandomListNode  root = new RandomListNode(head.label);
        RandomListNode  newHead = root;
        while (head!=null){
            if (head.next!=null){
                root.next = new RandomListNode(head.next.label);
            }
            if (head.random!=null){
                root.random = new RandomListNode(head.random.label);
            }
            root=root.next;
            head=head.next;
        }
        return newHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
