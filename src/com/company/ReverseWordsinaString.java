package com.company;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String str = s.trim();
        if (str==null || str.length()==0) return str;
//        char[] ch = str.toCharArray();
//        for (int i=0, j=ch.length-1; i<j; i++,j--){
//            char tmp = ch[i];
//            ch[i] = ch[j];
//            ch[j] = tmp;
//        }
        String[] strings = str.split("\\s+");
        for (int i=0, j=strings.length-1; i<j; i++, j--){
            String tmp = strings[i];
            strings[i]=strings[j];
            strings[j] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (String st : strings)
            sb.append(st+" ");
        return sb.toString().trim();
    }
    // Approach 2
    public String reverseWords2(String s) {
        char[] ch = s.toCharArray();
        for (int i=0, j=ch.length-1; i<j; i++,j--){
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
        int start=0, end=0;
        for (int i=0; i<ch.length; ++i){
            if (ch[i]!=' '){
                ch[end++]=ch[i];
            }
            else if (i>0 && ch[i-1]!=' '){
                reverse(ch, start, end-1);
                ch[end++]=' ';
                start=end;
            }
        }
        reverse(ch, start, end-1);

        return new String(ch, 0, end>0 && ch[end-1]==' ' ? end-1 : end);
    }

    private void reverse(char[] ch, int i, int j){
        while (i<j){
            char tmp = ch[i];
            ch[i++]=ch[j];
            ch[j--]=tmp;
        }
    }


//    public static void main(String[] args){
//        String.ReverseWordsinaString r = new String.ReverseWordsinaString();
//        System.out.println(r.reverseWords2("aaaa bbb cad eq dae ffa   "));
//    }
}
