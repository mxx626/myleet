package HashTable;
// HashTable
public class StrobogrammaticNumber {
    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

     Write a function to determine if a number is strobogrammatic. The number is represented as a string.

     Example 1:

     Input:  "69"
     Output: true
     Example 2:

     Input:  "88"
     Output: true
     Example 3:

     Input:  "962"
     Output: false
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        char[] ch = num.toCharArray();
        int [] arr = new int[10];
        arr[0]=1; arr[1]=1; arr[9]=1; arr[6]=1; arr[8]=1;
        int start=0, end=num.length()-1;
        while (start<=end){
            if (arr[ch[start]-'0']!=1 || arr[ch[end]-'0']!=1) return false;
            if (!valid(ch, start, end)) return false;
            start++; end--;
        }
        return true;
    }

    private boolean valid(char[] ch, int start, int end){
        if (start==end){
            return ch[start]=='0' || ch[start]=='1' || ch[start]=='8';
        }
        boolean res = (ch[start]=='8' && ch[end]=='8')
                ||(ch[start]=='0' && ch[end]=='0')
                ||(ch[start]=='1' && ch[end]=='1')
                ||(ch[start]=='6' && ch[end]=='9')
                ||(ch[start]=='9' && ch[end]=='6');
        return res;
    }
}
