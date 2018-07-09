package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute
 * difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 *      [7,1,3,6,1,4,7,1]
 *  6    i         i
 *  5
 * **/
public class BST_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<1 || t<0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i=0; i<nums.length; ++i){
            Long floor= set.floor((long)nums[i]+t);
            Long ceiling=set.ceiling((long)nums[i]-t);
            if ((floor!=null && floor >= nums[i])
                    || (ceiling!=null && ceiling <= nums[i]))
                return true;
            set.add((long)nums[i]);
            if (i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
