package Design;
// Design
import java.util.Stack;

public class MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

     push(x) -- Push element x onto stack.
     pop() -- Removes the element on top of the stack.
     top() -- Get the top element.
     getMin() -- Retrieve the minimum element in the stack.
     Example:
     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> Returns -3.
     minStack.pop();
     minStack.top();      --> Returns 0.
     minStack.getMin();   --> Returns -2.
     */
    Stack<Integer> st;
    Stack<Integer> minSt;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if (minSt.isEmpty() || minSt.peek()>=x){
            minSt.push(x);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        int popValue = st.pop();
        if (popValue == minSt.peek()) minSt.pop();
    }

    public int top() {
        if (st.isEmpty()) return -1;
        return st.peek();
    }

    public int getMin() {
        if (!minSt.isEmpty()){
            return minSt.peek();
        }
        else return st.peek();
    }
}
