package com.company;

public class PowerofFour {
    /**
     * iven an integer (signed 32 bits), write a function to check whether it is a power of 4.

     Example:
     Given num = 16, return true. Given num = 5, return false.

     Follow up: Could you solve it without loops/recursion?

     Credits:
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num>0 && ((num&(num-1))==0) && (0x55555555&num)!=0;
    }


    public boolean isPowerOfFour2(int num) {
        return num>0 && ((num&(num-1))==0) && (num-1)%3==0;
    }

}
