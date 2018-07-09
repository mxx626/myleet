package com.company;
// String
public class GoatLatin {
    /**
     * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

     We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

     The rules of Goat Latin are as follows:

     If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
     For example, the word 'apple' becomes 'applema'.

     If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
     For example, the word "goat" becomes "oatgma".

     Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
     For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
     Return the final sentence representing the conversion from S to Goat Latin.
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        if (S==null || S.length()==0) return S;
        StringBuilder tail = new StringBuilder();
        tail.append("a");
        String[] arr = S.split(" ");
        for (int i=0; i<arr.length; ++i){
            arr[i]=process(arr[i], tail);
            tail.append("a");
        }
        StringBuilder res = new StringBuilder();
        for (String word : arr) res.append(word).append(" ");
        return res.toString().substring(0, res.length()-1);
    }
    private String process(String word, StringBuilder sb){
        StringBuilder str = new StringBuilder();
        char cur = word.charAt(0);
        if (cur=='a' || cur=='A' || cur=='e' || cur=='E' || cur=='i'
                ||cur=='I' || cur=='o' || cur=='O' || cur=='u' || cur=='U'){
            str.append(word).append("ma").append(sb);
        }
        else {
            str.append(word.substring(1)).append(word.charAt(0)).append("ma").append(sb);
        }
        return str.toString();
    }
}
