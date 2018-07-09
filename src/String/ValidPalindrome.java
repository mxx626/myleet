package String;
// String
/**
 * 125. Valid Palindrome

 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0) return true;
        int i=0, j=s.length()-1;
        s = s.toUpperCase();
        while (i<j){
            while(i<s.length() && !(Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i)))) i++;
            while(j>=0 && !(Character.isDigit(s.charAt(j))||Character.isLetter(s.charAt(j)))) j--;
            if (i<s.length() && j>=0 && s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
