package com.company;

import sun.text.resources.cldr.fur.FormatData_fur;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * For example:
     * Given "25525511135",
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    private List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()<4){
            return res;
        }
        helper(s, 0, 0, "");
        return res;
    }
    private void helper (String s, int start, int dotCount, String str){
        if (dotCount>4) return;
        if (start==s.length() && dotCount==4){
            res.add(str.substring(0, str.length()-1));
            return;
        }
        for (int i=1; i<4; ++i){
            if (start+i>s.length()) break;
            String number = s.substring(start, start+i);
            if ((number.startsWith("0") && number.length()>1) || (i==3 && Integer.parseInt(number) >= 256)) continue;
            if (Integer.parseInt(number)<=255){
                helper(s, start+i, dotCount+1, str+number+".");
            }
        }
    }

    private List<String> restoreAddresses2(String s){
        if (s.length()<4) return res;
        StringBuilder sb = new StringBuilder();
        for (int a=1; a<4; ++a){
            for (int b=1; b<4; ++b){
                for (int c=1; c<4; ++c){
                    for (int d=1; d<4; ++d){
                        if (a+b+c+d == s.length()){
                            int _first = Integer.parseInt(s.substring(0, a));
                            int _second = Integer.parseInt(s.substring(a, a+b));
                            int _third = Integer.parseInt(s.substring(a+b, a+b+c));
                            int _fourth = Integer.parseInt(s.substring(a+b+c));
                            if (_first<=255 && _second<=255 && _third<=255 && _fourth<=255){
                                sb.append(_first+"."+_second+"."+_third+"."+_fourth);
                                if (sb.length()==s.length()+3){
                                    res.add(sb.toString());
                                }
                                sb.delete(0,sb.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
