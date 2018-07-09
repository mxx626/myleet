package String;
// TAG: String, Math
public class IntegerToRoman {
    /**
     * Given an integer, convert it to a roman numeral.

     Input is guaranteed to be within the range from 1 to 3999.
     从左往右 如果数字小于后一个， 则右边-左边
     */
    private static final int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<value.length; ++i){
            while (num>=value[i]){
                num -= value[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
