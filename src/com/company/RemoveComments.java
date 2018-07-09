package com.company;
// TAG: String
import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    /**
     *
     * @param source
     * @return
     */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isMul = false;
        for (String str : source){
            for (int i=0; i<str.length(); ++i){
                if (isMul){
                    if (str.charAt(i)=='*' && i<str.length()-1 && str.charAt(i+1)=='/'){
                        isMul=false;
                        i++;
                    }
                }
                else {
                    if (str.charAt(i)=='/' && i<str.length()-1 && str.charAt(i+1)=='/'){
                        break;
                    }
                    else if (str.charAt(i)=='/' && i<str.length()-1 && str.charAt(i+1)=='*'){
                        isMul=true;
                        i++;
                    }
                    else sb.append(str.charAt(i));
                }
            }
            if (!isMul && sb.length()>0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
