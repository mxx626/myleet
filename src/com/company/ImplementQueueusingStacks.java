package com.company;

import java.util.Stack;

public class ImplementQueueusingStacks {
    /**
     *Implement the following operations of a queue using stacks.

     push(x) -- Push element x to the back of queue.
     pop() -- Removes the element from in front of queue.
     peek() -- Get the front element.
     empty() -- Return whether the queue is empty.
     */
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int top = -1;
    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
        if (st1.size()==1) top = x;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (st1.isEmpty()) return -1;
        while(st1.size()>1){
            top = st1.pop();
            st2.push(top);
        }
        int tmp = st1.pop();
        while(!st2.isEmpty()) st1.push(st2.pop());
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        if (st1.isEmpty()) return -1;
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
    }
}
