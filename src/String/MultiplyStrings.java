package String;
// TAG: String, Math
public class MultiplyStrings {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")) return "0";

        int len1 = num1.length(), len2=num2.length();
        int[] number = new int[len1+len2];
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        for (int i=n1.length-1; i>=0; --i){
            if (n1[i]=='0') continue;
            int carry=0, idx=number.length-1-(n1.length-1-i);
            for (int j=n2.length-1; j>=0; --j){
                int mul = number[idx] + (n1[i]-'0') * (n2[j]-'0') + carry;
                carry = mul/10;
                number[idx--]=mul%10;
            }
            number[idx]+=carry;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<number.length; ++i){
            if (i==0 && number[i]==0) continue;
            sb.append(number[i]);
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1==null || num2==null) return "0";
        int[] digit = new int[num1.length()+num2.length()];
        for (int i=num1.length()-1; i>=0; --i){
            for (int j=num2.length()-1; j>=0; --j){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1=i+j, p2=i+j+1;
                int sum = product+digit[p2];
                digit[p1]+=sum/10;
                digit[p2]=sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : digit){
            if (!(num==0 && sb.length()==0)){
                sb.append(num);
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

}
