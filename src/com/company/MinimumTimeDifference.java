package com.company;
// TAG: String, Sort
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
    /**
     *
     * @param timePoints
     * @return
     */
    //Better
    public int findMinDifference2(List<String> timePoints) {
        boolean[] bucket = new boolean[24*60];
        for (String time : timePoints){
            int hour = 10*(time.charAt(0)-'0')+(time.charAt(1)-'0');
            int minu = 10*(time.charAt(3)-'0')+(time.charAt(4)-'0');
            int t = hour*60+minu;
            if (bucket[t]) return 0;
            bucket[t]=true;
        }
        int first=-1, last=-1, prev=-1, res=1440;
        for (int i=0; i<bucket.length; ++i){
            if (bucket[i]){
                last=i;
                if (first<0) first=i;
                if (prev>=0){
                    res = Math.min(res, i-prev);
                }
                prev=i;
            }
        }
        return Math.min(res, 1440+first-last);
    }



    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
        int res=1440;
        for (int i=1; i<timePoints.size(); ++i){
            int diff = calTime(timePoints.get(i))-calTime(timePoints.get(i-1));
            if (diff<res) res=diff;
            if (res==0) return res;
        }
        //time loop
        int head=0, tail = timePoints.size()-1;
        if (calTime(timePoints.get(head))+1440-calTime(timePoints.get(tail))<res)
            return calTime(timePoints.get(head))+1440-calTime(timePoints.get(tail));
        return res;
    }
    private int calTime (String str){
        String hour = str.substring(0,2);
        String minu = str.substring(3,5);
        return Integer.valueOf(hour)*60+Integer.valueOf(minu);
    }
}
