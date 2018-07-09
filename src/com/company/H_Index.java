package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 *  Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
 *  the researcher's h-index. According to the definition of h-index on Wikipedia: "A scientist has index h if h of
 *  his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 *  For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them
 *  had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each
 *  and the remaining two with no more than 3 citations each, his h-index is 3.
 *
 *  Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * **/
public class H_Index {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        int count=0;
        for (int j=citations.length-1; j>=0; --j){
            if (citations[j]>count)
                count++;
            else break;
        }
        return count;
    }

    //Counting Sort
    public int hIndex1(int[] citations){
        if (citations==null || citations.length==0) return 0;
        int[] helper = new int[citations.length+1];
        for (int i=0; i<citations.length; ++i){
            helper[citations[i]<=citations.length ? citations[i] : citations.length]+=1;
        }
        int sum=0;
        for (int j=citations.length; j>=0; --j){
            sum+=helper[j];
            if (sum>=j){
                return j;
            }
        }
        return 0;
    }
}

