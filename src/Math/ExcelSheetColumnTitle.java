package Math;
// Math
public class ExcelSheetColumnTitle {
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int carry = 26;
        while (n>0){
            n--;
            char digit = (char)(n%26+'A');
            sb.insert(0, digit);
            n /= carry;
        }
        return sb.toString();
    }
}
