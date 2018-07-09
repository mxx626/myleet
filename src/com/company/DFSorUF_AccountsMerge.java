package com.company;

import java.util.*;

public class DFSorUF_AccountsMerge {
    /**
     * Given a list accounts, each element accounts[i] is a list of strings, where the first element
     * accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

     Now, we would like to merge these accounts. Two accounts definitely belong to the same person
     if there is some email that is common to both accounts. Note that even if two accounts have the
     same name, they may belong to different people as people could have the same name. A person can
     have any number of accounts initially, but all of their accounts definitely have the same name.

     After merging the accounts, return the accounts in the following format: the first element of
     each account is the name, and the rest of the elements are emails in sorted order. The accounts
     themselves can be returned in any order.

     Example 1:

     Input:
     accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
     ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John",
     "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     Explanation:
     The first and third John's are the same person as they have the common email "johnsmith@mail.com".
     The second John and Mary are different people as none of their email addresses are used by other accounts.
     We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'],
     ['John', 'johnnybravo@mail.com'],
     ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

     Note:
     The length of accounts will be in the range [1, 1000].
     The length of accounts[i] will be in the range [1, 10].
     The length of accounts[i][j] will be in the range [1, 30].
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, Integer> emailToId = new HashMap<>();
        UnionFind set = new UnionFind(10000);
        int idx=0;
        for (List<String> list : accounts){
            String name = "";
            for (String email : list){
                if (name.equals("")){
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)){
                    emailToId.put(email, idx++);
                }
                set.Union(emailToId.get(list.get(1)), emailToId.get(email));
            }
        }
        Map<Integer, List<String>> res = new HashMap<>();
        for (String email : emailToName.keySet()){
            int root = set.Find(emailToId.get(email));
            res.computeIfAbsent(root, x->new ArrayList<>()).add(email);
        }
        for (List<String> list : res.values()){
            Collections.sort(list);
            list.add(0, emailToName.get(list.get(0)));
        }
        return new ArrayList<>(res.values());
    }
    class UnionFind {
        private int[] parent;
        private int[] rank;
        public UnionFind (int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i=0; i<parent.length; ++i){
                parent[i]=i;
                rank[i]=1;
            }
        }
        private int Find (int u){
            if (u!=parent[u]){
                parent[u]=Find(parent[u]);
            }
            return parent[u];
        }
        private boolean Union(int u, int v){
            int pu = Find(u);
            int pv = Find(v);
            if (pu==pv) return false;
            if (rank[pu]<rank[pv]) parent[pu]=pv;
            else if (rank[pv]<rank[pu]) parent[pv]=pu;
            else {
                parent[pu]=pv;
                rank[pv] += 1;
            }
            return true;
        }
    }
}
