package com.company;
// Design
import java.util.Stack;

/**
 *
 *716. Max Stack
 *
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.

 push(x) -- Push element x onto stack.
 pop() -- Remove the element on top of the stack and return it.
 top() -- Get the element on the top.
 peekMax() -- Retrieve the maximum element in the stack.
 popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than
 one maximum elements, only remove the top-most one.
 */
public class MaxStack {
//    private Stack<Integer> st;
//    private Stack<Integer> maxSt;
//    private int id;
//    /** initialize your data structure here. */
//    public MaxStack() {
//        st = new Stack<>();
//        maxSt = new Stack<>();
//    }
//
//    public void push(int x) {
//        int max = maxSt.isEmpty() ? x : maxSt.peek();
//        if (max>x) {
//            maxSt.push(max);
//        }
//        else maxSt.push(x);
//        st.push(x);
//    }
//
//    public int pop() {
//        maxSt.pop();
//        return st.pop();
//    }
//
//    public int top() {
//        return st.peek();
//    }
//
//    public int peekMax() {
//        return maxSt.peek();
//    }
//
//    public int popMax() {
//        int max = maxSt.peek();
//        Stack<Integer> tmp = new Stack<>();
//        while (st.peek()!=max) tmp.push(pop());
//        pop();
//        while (!tmp.isEmpty()) push(tmp.pop());
//        return max;
//    }


    private Node head;
    private Node tail;
    public MaxStack() {
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
        Node pre = tail.prev;
        Node cur = new Node(x, Math.max(x, pre.max));
        pre.next = cur;
        cur.next = tail;
        cur.prev = pre;
        tail.prev = cur;
    }

    public int pop() {
        Node pre = tail.prev;
        if (pre==head) return -1;
        pre.prev.next=tail;
        tail.prev=pre.prev;
        return pre.val;
    }

    public int top() {
        Node pre = tail.prev;
        if (pre==head) return -1;
        return pre.val;
    }

    public int peekMax() {
        Node pre = tail.prev;
        if (pre==head) return -1;
        return pre.max;
    }

    public int popMax() {
        Node cur = tail.prev;
        int curMax = cur.max;
        while (cur.prev!=head && cur.val!=curMax){
            cur = cur.prev;
        }
        Node pre = cur.prev;
        Node next = cur.next;
        pre.next=next;
        next.prev=pre;
        cur.prev=null;
        cur.next=null;
        while (next!=tail){
            next.max = Math.max(next.prev.max, next.val);
            next = next.next;
        }
        return curMax;
    }
    class Node {
        private int val;
        private int max;
        Node next;
        Node prev;
        public Node(int val, int max){
            this.val=val;
            this.max=max;
        }
    }
}
