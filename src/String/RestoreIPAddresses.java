package String;
// TAG: String, Backtracking, DFS
import java.util.List;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * Given a string containing only digits, restore it
     * by returning all possible valid IP address combinations.

     For example:
     Given "25525511135",

     return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s==null || s.length()<4 || s.length()>12) return res;
        for (int i=1; i<4 && i<s.length()-2; ++i){
            for (int j=i+1; j<i+4 && j<s.length()-1; ++j){
                for (int k=j+1; k<j+4 && k<s.length(); ++k){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());
                    if (isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4)){
                        res.add(s1+'.'+s2+'.'+s3+'.'+s4);
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid (String s){
        if(s.length()<1 || s.length()>3 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new LinkedList<>();
        if (s==null || s.length()<4 || s.length()>12) return res;
        helper(res, 0, new StringBuilder(), s, 0);
        return res;
    }
    private void helper(List<String> res, int idx, StringBuilder sb, String s, int dot){
        if (dot>4) return;
        if (dot==4 && idx==s.length()){
            res.add(sb.substring(0, sb.length()-1));
            return;
        }
        for (int i=1; i<4; ++i){
            if(idx+i>s.length()) return;
            String str = s.substring(idx, idx+i);
            if ((str.charAt(0)=='0' && str.length()>1) || Integer.parseInt(str)>255) return;
            int len=sb.length();
            sb.append(str+'.');
            helper(res, idx+i, sb, s, dot+1);
            sb.delete(len, sb.length());
        }
    }
}
