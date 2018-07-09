package Sort;
// TAG: Sort
import java.util.Comparator;
import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i=0; i<nums.length; ++i){
            str[i] = Integer.toString(nums[i]);
        }
        Comparator<String> mCom = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String num1 = o1+o2;
                String num2 = o2+o1;
                return num2.compareTo(num1);
            }
        };
        Arrays.sort(str, mCom);
        if (str[0].charAt(0)=='0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);
        return sb.toString();
    }
}
