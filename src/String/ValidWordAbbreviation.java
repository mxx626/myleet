package String;
// String
public class ValidWordAbbreviation {
    /**
     * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

     A string such as "word" contains only the following valid abbreviations:

     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

     Note:
     Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

     Example 1:
     Given s = "internationalization", abbr = "i12iz4n":

     Return true.
     Example 2:
     Given s = "apple", abbr = "a2e":

     * @param word
     * @param abbr
     * @return
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] arr = abbr.toCharArray();
        char[] org = word.toCharArray();
        int len = org.length;
        int count = 0;
        for (int i=0; i<arr.length; ++i){
            if (arr[i]>='a' && arr[i]<='z'){
                len--;
                if ((i+count)>org.length-1 || org[i+count]!=arr[i]) return false;
            }
            else {
                if (arr[i]=='0') return false;
                int mul = 0;
                int tmp = 0;
                while(i<arr.length && Character.isDigit(arr[i])){
                    mul = mul*10 + arr[i++]-'0';
                    tmp++;
                }
                count += mul-tmp;
                len -= mul;
                i--;
            }
        }
        return len==0;
    }
}
