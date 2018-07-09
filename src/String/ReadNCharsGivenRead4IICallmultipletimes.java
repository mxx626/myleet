package String;
/// String
/**
 * 158. Read N Characters Given Read4 II - Call multiple times

 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it
 returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n)
 that reads n characters from the file.

 Note:
 The read function may be called multiple times.

 Example 1:

 Given buf = "abc"
 read("abc", 1) // returns "a"
 read("abc", 2); // returns "bc"
 read("abc", 1); // returns ""
 Example 2:

 Given buf = "abc"
 read("abc", 4) // returns "abc"
 read("abc", 1); // returns ""
 */
public class ReadNCharsGivenRead4IICallmultipletimes {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] myBuf = new char[4];
    private int ptrBuf = 0;
    private int sizeBuf = 0;
    public int read(char[] buf, int n) {
        int counter = 0;
        while (counter < n){
            if (ptrBuf < sizeBuf){
                buf[counter++]=myBuf[ptrBuf++];
            }
            else {
                sizeBuf = read4(myBuf);
                ptrBuf = 0;
                if (sizeBuf==0) break;
            }
        }
        return counter;
    }

    private int read4(char[] arr){return 0;};
}
