package com.company;
/**
 *Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first
 * two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * Follow up: How would you handle overflow for very large input integers?
 *
 *      length = n, first = (n-1)/2, second = j-i, sum = (n-j)>=Math.max(j-i, i)
 *
 *
 * **/
public class String_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num==null || num.length()==0) return false;
        int n = num.length();
        for (int i = 1; i <= (n-1)/2; i++){
            if (num.charAt(0) == '0' && i >= 2) break;
            for (int j = i+1; n - j >= j - i && n - j >= i; j++){
                if (num.charAt(i) == '0' && j - i >= 2) continue;
                Long first = Long.parseLong(num.substring(0, i));
                Long second = Long.parseLong(num.substring(i, j));
                String sub = num.substring(j);
                if (isValid(sub, first, second)) return true;
            }
        }
        return false;
    }

    public boolean isValid(String substring, Long first, Long second){
        if (substring.equals("")) return true;
        Long sum = first + second;
        String subSum = sum.toString();
        if (!substring.startsWith(subSum)) {
            return false;
        }
        return isValid(substring.substring(subSum.length()), second, sum);
    }
}
