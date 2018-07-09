package String;
// TAG:String
public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
     * rows like this: (you may want to display this pattern in a fixed font for better
     * legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"



     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s.length()<=numRows || numRows<=1) return s;
        char[] ch = s.toCharArray();
        int step1=2*numRows-2, step2=0, row=0;
        StringBuilder sb = new StringBuilder();
        while (row<numRows){
            int c=0;
            for (int i=row; i<ch.length;){
                sb.append(ch[i]);
                c++;
                if (row==0) i+=step1;
                else if (row==numRows-1) i+=step2;
                else {
                    if (c%2==1) i+=step1;
                    else if (c%2==0) i+=step2;
                }
            }
            step1 -=2;
            step2 +=2;
            row++;
        }
        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        if (s.length()<=numRows || numRows<=1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        char[] ch = s.toCharArray();
        for (int i=0; i<numRows; i++){
            sb[i]=new StringBuilder();
        }
        int len=0;
        while (len<s.length()){
            for (int idx=0; idx<numRows && len<s.length(); idx++){
                sb[idx].append(ch[len++]);
            }
            for (int idx=numRows-2; idx>=1 && len<s.length(); idx--){
                sb[idx].append(ch[len++]);
            }
        }
        for (int i=1; i<sb.length; ++i){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
