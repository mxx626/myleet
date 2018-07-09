package String;
// String
import java.util.ArrayList;
import java.util.List;

public class MaskingPersonalInformation {
    /**
     * We are given a personal information string S, which may represent either
     * an email address or a phone number.

     We would like to mask this personal information according to the following rules:


     1. Email address:

     We define a name to be a string of length ≥ 2 consisting of only lowercase l
     etters a-z or uppercase letters A-Z.

     An email address starts with a name, followed by the symbol '@', followed by
     a name, followed by the dot '.' and followed by a name.

     All email addresses are guaranteed to be valid and in the format of "name1@name2.name3".

     To mask an email, all names must be converted to lowercase and all letters
     between the first and last letter of the first name must be replaced by 5 asterisks '*'.


     2. Phone number:

     A phone number is a string consisting of only the digits 0-9 or the characters
     from the set {'+', '-', '(', ')', ' '}. You may assume a phone number contains 10 to 13 digits.

     The last 10 digits make up the local number, while the digits before those make
     up the country code. Note that the country code is optional. We want to expose
     only the last 4 digits and mask all other digits.

     The local number should be formatted and masked as "***-***-1111", where 1
     represents the exposed digits.

     To mask a phone number with country code like "+111 111 111 1111", we write
     it in the form "+***-***-***-1111".  The '+' sign and the first '-' sign before
     the local number should only exist if there is a country code.  For example, a 12
     digit phone number mask should start with "+**-".

     Note that extraneous characters like "(", ")", " ", as well as extra dashes
     or plus signs not part of the above formatting scheme should be removed.
     * @param S
     * @return
     */
    public String maskPII(String S) {
        int idx = S.indexOf("@");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        List<Character> list = new ArrayList<>();
        if (idx==-1){
            char[] arr = S.toCharArray();
            int count=0;
            int c = 0;
            for (int i=arr.length-1; i>=0; --i){
                if (Character.isDigit(arr[i])&&count<4){
                    list.add(0,arr[i]);
                    count++;
                    if (count==4){
                        list.add(0,'-');
                        count++;
                    }
                }
                else if (Character.isDigit(arr[i]) && count>4 && c<6){
                    list.add(0,'*');
                    c++;
                    if (c%3==0){
                        list.add(0,'-');
                    }
                }
                else if (Character.isDigit(arr[i]) && c>=6){
                    flag=true;
                    list.add(0,'*');
                    c++;
                }
                else continue;
            }
        }
        if (flag){
            sb.append("+");
            for (Character ch : list){
                sb.append(ch);
            }
            return sb.toString();
        }
        else if (idx<0 && !flag){
            for (int i=1; i<list.size(); ++i){
                sb.append(list.get(i));
            }
            System.out.println(1);
            return sb.toString();
        }
        if (idx>=0) {
            sb.append(S.substring(0,1).toLowerCase()).append("*****").append(S.substring(idx-1).toLowerCase());
        }
        return sb.toString();
    }
}
