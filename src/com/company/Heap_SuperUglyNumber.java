package com.company;

import java.util.PriorityQueue;

/**
 *  Write a program to find the nth super ugly number.
 *  Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For
 *  example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes
 *  = [2, 7, 13, 19] of size 4.
 *
 *  Note:
 *  (1) 1 is a super ugly number for any given primes.
 *  (2) The given numbers in primes are in ascending order.
 *  (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *  (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * **/
public class Heap_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        dp[0]=1;
        for (int i=1; i<n; i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i=1; i<n; i++){
            for (int j=0; j<primes.length; ++j) {
                dp[i]=Math.min(dp[i], dp[index[j]]*primes[j]);
            }
            for (int k=0; k<primes.length; ++k){
                if (dp[i]==dp[index[k]]*primes[k]){
                    index[k]++;
                }
            }
        }
        return dp[n-1];
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] res = new int[n];
        res[0]=1;
        PriorityQueue<Num> priorityQueue = new PriorityQueue<>((a,b)->(a.val-b.val));
        for (int i=0; i<primes.length; ++i){
            priorityQueue.add(new Num(primes[i], 1, primes[i]));
        }
        for (int i=1; i<n; ++i){
            res[i]=priorityQueue.peek().val;
            while (priorityQueue.peek().val == res[i]){
                Num next = priorityQueue.poll();
                priorityQueue.add(new Num(next.prime*res[next.index], next.index+1, next.prime));
            }
        }
        return res[n-1];
    }
    class Num{
        int val;
        int index;
        int prime;
        public Num (int val, int index, int prime){
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}
