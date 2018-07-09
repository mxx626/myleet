package com.company;
// TAG: Array, Two Pointer
public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at
     * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
     * line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms
     * a container, such that the container contains the most water.

     Note: You may not slant the container and n is at least 2.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int start=0, end=height.length-1;
        while (start<end){
            res = Math.max(res, (end-start)*Math.min(height[start], height[end]));
            if (height[start]<height[end]){
                start++;
            }
            else end--;
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int start=0, end=height.length-1;
        while (start<end){
            res = Math.max(res, (end-start)*Math.min(height[start], height[end]));
            if (height[start]<height[end]){
                int val = height[start];
                while (start<end && height[start]<=val) start++;
            }
            else if (height[start]>height[end]){
                int val = height[end];
                while (start<end && height[end]<=val) end--;
            }
            else{
                int val = height[start];
                while (start<end && height[start]<=val) start++;
                while (start<end && height[end]<=val) end--;
            }
        }
        return res;
    }
}
