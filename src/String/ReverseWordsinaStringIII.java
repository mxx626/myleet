package String;
// String
/**
 * 557. Reverse Words in a String III

 Given a string, you need to reverse the order of characters in each word within a
 sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be
 any extra space in the string.


 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i=0;
        for (int j=0; j<ch.length; ++j){
            if(ch[j]==' ' || j==ch.length-1){
                reverse(ch, i, j==ch.length-1 ? j : j-1);
                i=j+1;
            }
        }
        return new String(ch);
    }
    private void reverse(char[] ch, int i, int j){
        while (i<j){
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }
}
