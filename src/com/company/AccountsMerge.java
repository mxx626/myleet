package com.company;
// DFS, UF
import java.util.*;

public class AccountsMerge {
    /**
     * Given a list accounts, each element accounts[i] is a list of strings,
     * where the first element accounts[i][0] is a name, and the rest of the
     * elements are emails representing emails of the account.

     Now, we would like to merge these accounts. Two accounts definitely belong
     to the same person if there is some email that is common to both accounts.
     Note that even if two accounts have the same name, they may belong to
     different people as people could have the same name. A person can have any
     number of accounts initially, but all of their accounts definitely have the
     same name.

     After merging the accounts, return the accounts in the following format:
     the first element of each account is the name, and the rest of the elements
     are emails in sorted order. The accounts themselves can be returned in any order.

     Example 1:
     Input:
     accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
     ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
     ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
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
        List<List<String>> res = new ArrayList<>();
        UF uf = new UF();
        Map<String, String> owner = new HashMap<>();
        for (List<String> list : accounts){
            for(int i=1; i<list.size(); ++i){
                if(!uf.root.containsKey(list.get(i))){
                    uf.root.put(list.get(i), list.get(i));
                }
                owner.put(list.get(i), list.get(0));
            }
        }

        for (List<String> list : accounts){
            String parent = list.get(1);
            for (int i=2; i<list.size(); ++i){
                uf.union(list.get(i), parent);
            }
        }
        Map<String, TreeSet<String>> map = new HashMap<>();
        for (List<String> list : accounts){
            String p = uf.find(list.get(1));
            if (!map.containsKey(p))
                map.put(p, new TreeSet<>());
            for (int i=1; i<list.size(); ++i){
                map.get(p).add(list.get(i));
            }
        }
        for (String key : map.keySet()){
            List<String> tmp = new ArrayList<>(map.get(key));
            tmp.add(0, owner.get(key));
            res.add(tmp);
        }
        return res;

    }
    private class UF{
        private Map<String, String> root;
        public UF(){
            root = new HashMap<>();
        }

        private String find(String s){
            if (!root.containsKey(s)) root.put(s,s);
            return root.get(s) == s ? s : find(root.get(s));
        }

        private void union(String s1, String s2){
            String root_s1 = find(s1);
            String root_s2 = find(s2);
            if (!root_s1.equals(root_s2)){
                root.put(root_s1, root_s2);
            }
        }
    }
}
