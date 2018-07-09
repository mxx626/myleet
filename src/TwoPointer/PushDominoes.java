package TwoPointer;
// Two Pointer
/**
 * 838. Push Dominoes

 There are N dominoes in a line, and we place each domino vertically upright.

 In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



 After each second, each domino that is falling to the left pushes the adjacent domino on the left.

 Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

 When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

 For the purposes of this question, we will consider that a falling domino expends no additional force to
 a falling or already fallen domino.

 Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the
 left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

 Return a string representing the final state.

 Example 1:

 Input: ".L.R...LR..L.."
 Output: "LL.RR.LLRRLL.."
 Example 2:

 Input: "RR.L"
 Output: "RR.L"
 Explanation: The first domino expends no additional force on the second domino.
 Note:

 0 <= N <= 10^5
 String dominoes contains only 'L', 'R' and '.'

 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int r=-1;
        int l=-1;
        char[] ch = dominoes.toCharArray();
        for (int i=0; i<ch.length; ++i){
            if (ch[i]=='L'){
                if (r==-1 && l+1<i){
                    int s = l+1;
                    while (s<i) ch[s++]='L';
                }
                else if(r!=-1){
                    int s=r;
                    int e=i;
                    while (s<e){
                        ch[s++]='R';
                        ch[e--]='L';
                    }
                }
                r=-1;
                l=i;
            }
            else if (ch[i]=='R'){
                if (r>=0) {
                    int s=r+1;
                    while(ch[s]=='.') ch[s++]='R';
                }
                if (l<r) l=-1;
                r=i;
            }
        }
        while (r>=0 && r<ch.length){
            ch[r++]='R';
        }
        return new String(ch);
    }
}
