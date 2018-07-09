package com.company;
// TAG: String, DP, Count
public class ValidParenthesisString {
    /**
     * Given a string containing only three types of characters: '(', ')' and '*', write a function
     * to check whether this string is valid. We define the validity of a string by these rules:

     Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     Any right parenthesis ')' must have a corresponding left parenthesis '('.
     Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     An empty string is also valid.
     Example 1:
     Input: "()"
     Output: True
     Example 2:
     Input: "(*)"
     Output: True
     Example 3:
     Input: "(*))"
     Output: True
     Note:
     The string size will be in the range [1, 100].
     * @param s
     * @return
     */
    //Best
    public boolean checkValidString4(String s) {
        int minOp=0, maxOp=0;
        for (int i=0; i<s.length(); ++i){
            if (s.charAt(i)=='(') minOp++; else minOp--;
            if (s.charAt(i)!=')') maxOp++; else maxOp--;
            if (maxOp<0) return false;
            if (minOp<0) minOp=0;
        }
        return minOp==0;
    }



    //first
    private int[][] memo;
    public boolean checkValidString(String s) {
        int len=s.length();
        if (len==0) return true;
        memo=new int[len][len];
        return dfs(s.toCharArray(), 0, len-1);
    }
    private boolean dfs(char[] ch, int i, int j){
        if (i>j) return true;
        if (memo[i][j]>0){
            return memo[i][j]==2;
        }
        if (i==j) {
            if (ch[i]=='*') {
                memo[i][j]=2;
                return true;
            }
            else {
                memo[i][j]=1;
                return false;
            }
        }
        if ((ch[i]=='('||ch[i]=='*')&&(ch[j]==')'||ch[j]=='*')&&dfs(ch, i+1, j-1)){
            memo[i][j]=2;
            return true;
        }
        for (int p=i; p<j; ++p){
            if (dfs(ch, i, p)&&dfs(ch, p+1, j)){
                memo[i][j]=2;
                return true;
            }
        }
        memo[i][j]=1;
        return false;
    }

    //Second
    public boolean checkValidString2(String s) {
        int l=s.length();
        if (l==0) return true;
        memo=new int[l][l];
        for (int i=0; i<l; ++i)
            memo[i][i] = s.charAt(i)=='*' ? 1 : 0;
        for (int len=2; len<=l; ++len){
            for (int i=0; i<=l-len; ++i){
                int j=i+len-1;
                if ((s.charAt(i)=='('||s.charAt(i)=='*')&&(s.charAt(j)==')'||s.charAt(j)=='*')){
                    if (len==2 || memo[i+1][j-1]==1){
                        memo[i][j]=1;
                        continue;
                    }
                }
                for (int p=i; p<j; ++p){
                    if (memo[i][p]==1 && memo[p+1][j]==1){
                        memo[i][j]=1;
                        break;
                    }
                }
            }
        }
        return memo[0][l-1]==1;
    }

    //Third
    public boolean checkValidString3(String s) {
        int l=s.length();
        if (l==0) return true;
        memo=new int[l][l+1];
        return isValid(0, 0, s.toCharArray());
    }
    private boolean isValid(int cnt, int pos, char[] ch){
        if (cnt<0) return false;
        if (pos>=ch.length){
            return cnt==0;
        }
        if (memo[pos][cnt]!=0){
            return memo[pos][cnt]==2;
        }
        boolean ret = false;
        if (ch[pos]=='(') ret=isValid(cnt+1, pos+1, ch);
        else if (ch[pos]==')') ret=isValid(cnt-1, pos+1, ch);
        else{
            ret = isValid(cnt, pos+1, ch)
                    ||isValid(cnt+1, pos+1, ch)
                    ||isValid(cnt-1, pos+1, ch);
        }
        memo[pos][cnt]= ret ? 2 : 1;
        return ret;
    }
}
