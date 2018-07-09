package com.company;
// TAG: Array, TreeMap, BST, Binary Search
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class MyCanlanderI {

    private TreeMap<Integer, Integer> map;
    public MyCanlanderI() {
        map = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        if (floor!=null && map.get(floor)>start) return false;
        Integer ceiling = map.ceilingKey(start);
        if (ceiling!=null && ceiling<end) return false;
        map.put(start, end);
        return true;
    }
/// Best Approach
    class TreeNode {
        private int start;
        private int end;
        TreeNode left;
        TreeNode right;
        public TreeNode(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    private TreeNode root;

    public boolean book2(int start, int end) {
        if (root==null){
            root=new TreeNode(start, end);
            return true;
        }
        TreeNode cur = root;
        while (cur!=null){
            if (end<=cur.start){
                if (cur.left==null){
                    cur.left=new TreeNode(start, end);
                    return true;
                }
                cur=cur.left;
            }
            else if (start>=cur.end){
                if (cur.right==null){
                    cur.right=new TreeNode(start, end);
                    return true;
                }
                cur=cur.right;
            }
            else {
                return false;
            }
        }
        return false;
    }

    //Third
    private List<int[]> list = new LinkedList<>();

    public boolean book3(int start, int end) {
        int i=0, j=list.size()-1;
        while(i<=j){
            int m = i+(j-i)/2;
            int[] mid = list.get(m);
            if (mid[0]==start) return false;
            else if (mid[0]>start){
                j=m-1;
            }
            else if (mid[0]<start){
                i=m+1;
            }
        }
        if (i>0 && list.get(i-1)[1]>start) return false;
        else if (i<list.size() && list.get(i)[0]<end) return false;
        list.add(i, new int[]{start, end});
        return true;
    }
}
