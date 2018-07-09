package com.company;
// TAG: Array, HashTable
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
    /**
     *  Given an array of integers and an integer k, find out whether there are two distinct indices i
     *  and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            else {
                if (i-map.get(nums[i])<=k) return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }

    //Better
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; ++i){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
