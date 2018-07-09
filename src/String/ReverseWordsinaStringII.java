package String;
// TAG: String, Two POinter
public class ReverseWordsinaStringII {
    /**
     *Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

     The input string does not contain leading or trailing spaces and the words are always separated by a single space.

     For example,
     Given s = "the sky is blue",
     return "blue is sky the".

     Could you do it in-place without allocating extra space?

     Related problem: Rotate Array
     * @param str
     */

    // more understandable
    public void reverseWords2(char[] str) {
        reverse2(str, 0, str.length-1);
        int start=0;
        for (int i=0; i<=str.length; ++i){
            if (i==str.length || str[i]==' '){
                reverse2(str, start, i-1);
                start=i+1;
            }
        }
    }
    private void reverse2(char[] str, int i, int j){
        while (i<j){
            char tmp = str[i];
            str[i]=str[j];
            str[j]=tmp;
            i++;
            j--;
        }
    }




    public void reverseWords(char[] str) {
        for (int i=0, j=str.length-1; i<j; ++i,--j){
            char tmp = str[i];
            str[i]=str[j];
            str[j]=tmp;
        }
        int end=0;
        while (end<str.length){
            int start=end;
            if (str[end]!=' '){
                while (end<str.length && str[end]!=' ') end++;
                reverse(str, start, end-1);
                start=end+1;
            }
            else end++;
        }
    }
    private void reverse(char[] str, int i, int j){
        while (i>=0 && j<str.length && i<j){
            char tmp = str[i];
            str[i]=str[j];
            str[j]=tmp;
            i++;
            j--;
        }
    }
}
