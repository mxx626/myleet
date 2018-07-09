package com.company;
import java.util.ArrayList;
import java.util.List;
/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
 * **/
public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k==0 || n==0) return res;
        DFS(new ArrayList<>(), n, k, 1);
        return res;
    }

    public void DFS(List<Integer> list, int n, int k, int start){
        if (list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        else if (list.size()>k){
            return;
        }
        else {
            for (int i=start; i<=n; ++i){
                list.add(i);
                DFS(list, n, k, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
