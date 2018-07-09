package com.company;
// Bit, Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 401. Binary Watch

 A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6
 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.


 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently
 on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example
 "10:2" is not valid, it should be "10:02".
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        if (num>10) return new ArrayList<>();
        if (num==0) return Arrays.asList(new String[]{"0:00"});
        int i=0;
        List<String> res = new ArrayList<>();
        while (i<=num){
            List<Integer> hour = calHour(i);
            List<Integer> minutes = calMinutes(num-i);
            i++;
            if (hour.size()==0 || minutes.size()==0) continue;
            for (int h=0; h<hour.size(); ++h){
                for (int m=0; m<minutes.size(); ++m){
                    res.add(""+hour.get(h)+":"+(minutes.get(m)<10 ? ("0"+minutes.get(m)) : minutes.get(m)));
                }
            }
        }
        return res;
    }
    private List<Integer> calHour(int num){
        List<Integer> res= new ArrayList<>();
        for (int i=0; i<=11; ++i){
            if (Integer.bitCount(i)==num){
                res.add(i);
            }
        }
        return res;
    }
    private List<Integer> calMinutes(int num){
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<=59; ++i){
            if (Integer.bitCount(i)==num){
                res.add(i);
            }
        }
        return res;
    }
}
