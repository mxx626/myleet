package Stack;
// Stack
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    /**
     * Implement the following operations of a stack using queues.

     push(x) -- Push element x onto stack.
     pop() -- Removes the element on top of the stack.
     top() -- Get the top element.
     empty() -- Return whether the stack is empty.
     Example:
     */
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top = 0;
    /** Initialize your data structure here. */
    public ImplementStackusingQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.isEmpty()) return -1;
        while (q1.size()>1){
            top = q1.poll();
            q2.add(top);
        }
        int tmp = q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return tmp;
    }
    /** Get the top element. */
    public int top() {
        if (!q1.isEmpty()) return top;
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
