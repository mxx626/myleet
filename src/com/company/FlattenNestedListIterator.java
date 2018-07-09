package com.company;
// Stack, Design
import DFSorBFS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<Integer> {
    private Stack<NestedInteger> _stack= null;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        _stack = new Stack<>();
        for (int i=nestedList.size()-1; i>=0; --i){
            NestedInteger cur = nestedList.get(i);
            addToStack(cur);
        }
    }

    @Override
    public Integer next() {
        return _stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !_stack.isEmpty();
    }

    private void addToStack(NestedInteger cur){
        if (cur.isInteger()) {
            _stack.push(cur);
            return;
        }
        else if (cur.getList()==null || cur.getList().size()==0) return;
        for (int i=cur.getList().size()-1; i>=0; --i){
            addToStack(cur.getList().get(i));
        }
    }
}
