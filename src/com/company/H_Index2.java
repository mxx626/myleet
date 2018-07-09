package com.company;
/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * **/
public class H_Index2 {
    public int hIndex(int[] citations) {
        int res=0;
        while (res<citations.length && citations[citations.length-1-res]>res){
            res++;
        }
        return res;
    }

    //Binary Search
    public int hIndex1(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        int start=0, end=citations.length-1;
        int len = citations.length;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (citations[mid]== len-mid) return (len-mid);
            else if (citations[mid]>len-mid){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return len-start;
    }
}
