package com.company;
// TAG: Set, LinkedList, Queue
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DesignPhoneDirectory {
    /**
     * Design a Phone Directory which supports the following operations:

     get: Provide a number which is not assigned to anyone.
     check: Check if a number is available or not.
     release: Recycle or release a number.
     Example:

     // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
     PhoneDirectory directory = new PhoneDirectory(3);

     // It can return any available phone number. Here we assume it returns 0.
     directory.get();

     // Assume it returns 1.
     directory.get();

     // The number 2 is available, so return true.
     directory.check(2);

     // It returns 2, the only number that is left.
     directory.get();

     // The number 2 is no longer available, so return false.
     directory.check(2);

     // Release number 2 back to the pool.
     directory.release(2);

     // Number 2 is available again, return true.
     directory.check(2);
     */
    private HashSet<Integer> set = new HashSet();
    private Queue<Integer> queue = new LinkedList<>();
    int max;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        max=maxNumbers;
        for (int i=0; i<max; ++i){
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer res = queue.poll();
        if (res==null) return -1;
        set.add(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number<0 || number>=max) return false;
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.remove(number)){
            queue.offer(number);
        }
    }
}
