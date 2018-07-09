package com.company;
// Array
public class MaximizeDistancetoClosestPerson {
    /**
     *In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

     There is at least one empty seat, and at least one person sitting.

     Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

     Return that maximum distance to closest person.

     Example 1:

     Input: [1,0,0,0,1,0,1]
     Output: 2
     Explanation:
     If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
     If Alex sits in any other open seat, the closest person has distance 1.
     Thus, the maximum distance to the closest person is 2.
     Example 2:

     Input: [1,0,0,0]
     Output: 3
     Explanation:
     If Alex sits in the last seat, the closest person is 3 seats away.
     This is the maximum distance possible, so the answer is 3.
     Note:

     1 <= seats.length <= 20000
     seats contains only 0s or 1s, at least one 0, and at least one 1.
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int head = 0;
        int tail = 0;
        int i=0, j=seats.length-1;
        for (i=0; i<seats.length; ++i){
            if (seats[i]==0) head++;
            else break;
        }
        for (j=seats.length-1; j>=0; --j){
            if (seats[j]==0) tail++;
            else break;
        }
        int res = 0;
        int count = 0;
        for (int x=i; x<=j; ++x){
            if (seats[x]==0) count++;
            else {
                res = Math.max(res, count);
                count=0;
            }
        }
        return Math.max(head, Math.max(tail, (res+1)/2));
    }

    public int maxDistToClosest2(int[] seats) {
        int i=0, j=0, n=seats.length;
        int res=0;
        for (i=j=0; j<n; ++j){
            if (seats[j]==1){
                if (i==0) res = j-i;
                else {
                    res=Math.max(res, (j-i+1)/2);
                }
                i=j+1;
            }
        }
        res= Math.max(res, n-i);
        return res;
    }
}
