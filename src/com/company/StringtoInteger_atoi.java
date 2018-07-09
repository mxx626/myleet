package com.company;
// TAG: Math, String
public class StringtoInteger_atoi {
    /**
     * Implement atoi to convert a string to an integer.

     Hint: Carefully consider all possible input cases. If you want a challenge, please do
     not see below and ask yourself what are the possible input cases.

     Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
     You are responsible to gather all the input requirements up front.



     Requirements for atoi:

     The function first discards as many whitespace characters as necessary until the first
     non-whitespace character is found. Then, starting from this character, takes an optional
     initial plus or minus sign followed by as many numerical digits as possible, and interprets
     them as a numerical value.

     The string can contain additional characters after those that form the integral number,
     which are ignored and have no effect on the behavior of this function.

     If the first sequence of non-whitespace characters in str is not a valid integral number,
     or if no such sequence exists because either str is empty or it contains only whitespace
     characters, no conversion is performed.

     If no valid conversion could be performed, a zero value is returned. If the correct value
     is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int res=0;
        int sign=1;
        int ptr=0;
        int bound = Integer.MAX_VALUE/10;
        if (str.length()==0) return 0;
        while (ptr<str.length() && str.charAt(ptr)==' ') ptr++;
        if (str.charAt(ptr)=='+' || str.charAt(ptr)=='-'){
            sign = str.charAt(ptr)=='-' ? -1 : 1;
            ptr++;
        }

        for (int i=ptr; i<str.length(); ++i){
            int digit = str.charAt(i)-'0';
            if (digit<0 || digit>9) break;
            if (res>bound || res==bound && digit >7) return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10+digit;
        }
        return sign*res;
    }
}
