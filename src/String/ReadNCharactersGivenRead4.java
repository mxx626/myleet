package String;
// String
/**
 * 157. Read N Characters Given Read4

 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if
 there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n
 characters from the file.

 Example 1:

 Input: buf = "abc", n = 4
 Output: "abc"
 Explanation: The actual number of characters read is 3, which is "abc".
 Example 2:

 Input: buf = "abcde", n = 5
 Output: "abcde"
 Note:
 The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        boolean eof = false;
        int idx = 0;
        char[] tmp = new char[4];
        while (!eof && idx<n){
            int count = read4(tmp);
            eof = count<4;
            count = Math.min(count, n-idx);
            for (int i=0; i<count; ++i){
                buf[idx++]=tmp[i];
            }
        }
        return idx;
    }
    private int read4(char[] arr){return 0;};
}
