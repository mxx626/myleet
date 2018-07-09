package com.company;
// Design;
public class DesignCompressedStringIterator {
    private String str = null;
    private int ptr = 0;
    private int num = 0;
    private char ch = ' ';

    /**
     * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

     The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

     next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
     hasNext() - Judge whether there is any letter needs to be uncompressed.

     Note:
     Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

     Example:

     StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

     iterator.next(); // return 'L'
     iterator.next(); // return 'e'
     iterator.next(); // return 'e'
     iterator.next(); // return 't'
     iterator.next(); // return 'C'
     iterator.next(); // return 'o'
     iterator.next(); // return 'd'
     iterator.hasNext(); // return true
     iterator.next(); // return 'e'
     iterator.hasNext(); // return false
     iterator.next(); // return ' '
     * @param compressedString
     */
    public DesignCompressedStringIterator(String compressedString) {
        this.str = compressedString;
    }

    public char next() {
        if (!hasNext()) return ' ';
        if (num==0){
            ch = str.charAt(ptr++);
            while (ptr<str.length() && Character.isDigit(str.charAt(ptr))){
                num = num*10 + str.charAt(ptr++)-'0';
            }
        }
        num--;
        return ch;

    }

    public boolean hasNext() {
        return ptr!=str.length() || num!=0;
    }
}
