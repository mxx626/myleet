public class tmp {
    public static int reverseBits(int n) {
        int sign = 1<<31;
        int size = 31;
        int res = 0;
        while (size!=0){
            res <<= 1;
            res |= n&1;
            n >>= 1;
            size--;
        }
        return res;
    }
    public static void  main(String[] args){
        System.out.println(Integer.toBinaryString(10));
        System.out.println(reverseBits(10));
        System.out.println(Integer.toBinaryString(reverseBits(10)));
    }

}
