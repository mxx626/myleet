package Design;
// Design
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector implements Iterator<Integer>{
    private Iterator<List<Integer>> row = null;
    private Iterator<Integer> col = null;

    /**
     * mplement an iterator to flatten a 2d vector.

     Example:

     Input: 2d vector =
     [
     [1,2],
     [3],
     [4,5,6]
     ]
     Output: [1,2,3,4,5,6]
     Explanation: By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].
     Follow up:
     As an added challenge, try to code it using only iterators in C++ or iterators in Java.
     * @param vec2d
     */
    public Flatten2DVector(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return col.next();
    }

    @Override
    public boolean hasNext() {
        while((col==null || !col.hasNext()) && row.hasNext()){
            col = row.next().iterator();
        }
        return col!=null && col.hasNext();
    }
}
