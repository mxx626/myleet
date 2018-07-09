package Design;
// Design
import java.util.Iterator;

/**
 * 284. Peeking Iterator
 Given an Iterator class interface with methods: next() and hasNext(), design and implement
 a PeekingIterator that support the peek() operation -- it essentially peek() at the element
 that will be returned by the next call to next().

 Example:

 Assume that the iterator is initialized to the beginning of the list: [1,2,3].

 Call next() gets you 1, the first element in the list.
 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 You call next() the final time and it returns 3, the last element.
 Calling hasNext() after that should return false.
 */
public class PeekingIterator {
    Iterator<Integer> iter;
    Integer top;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        this.top = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext() && top==null) return null;
        if (top!=null) return top;
        top = iter.next();
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        if (!hasNext() && top==null) return null;
        if (top!=null){
            int res = top;
            top = null;
            return res;
        }
        return iter.next();
    }

    public boolean hasNext() {
        return (iter.hasNext() || top!=null);
    }
}
