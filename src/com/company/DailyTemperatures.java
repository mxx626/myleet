package com.company;

import java.util.Stack;

public class DailyTemperatures {
    /**
     *  Given a list of daily temperatures, produce a list that, for each day in the input,
     *  tells you how many days you would have to wait until a warmer temperature. If there
     *  is no future day for which this is possible, put 0 instead.
     *  For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your
     *  output should be [1, 1, 4, 2, 1, 1, 0, 0].
     *  Note: The length of temperatures will be in the range [1, 30000]. Each temperature
     *  will be an integer in the range [30, 100].
     *              73, 74, 75, 71, 69, 72, 76, 73
     *                                       i
     *       75 72
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        if (temperatures==null || temperatures.length==0 || temperatures.length==1) return ret;
        Stack<Integer> stack = new Stack<>();
        int idx=1;
        stack.push(0);
        while (!stack.isEmpty() && idx<temperatures.length){
            while (!stack.isEmpty() && temperatures[idx] > temperatures[stack.peek()]) {
                int tmp = stack.pop();
                ret[tmp] = idx-tmp ;
            }
            stack.push(idx++);
        }
        return ret;
    }
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        if (temperatures==null || temperatures.length==0 || temperatures.length==1) return ret;
        int stack[] = new int[temperatures.length];
        int top=-1;
        for (int i=0; i<temperatures.length; ++i){
            while (top>-1 && temperatures[i]>temperatures[stack[top]]){
                int idx = stack[top--];
                ret[idx]=i-idx;
            }
            stack[++top]=i;
        }
        return ret;
    }
}
