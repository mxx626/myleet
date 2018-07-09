package com.company;
// String
/**
 * 800. Similar RGB Color

 In the following, every capital letter represents some hexadecimal digit from 0 to f.

 The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example,
 "#15c" is shorthand for the color "#1155cc".

 Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (
 CD - WX)^2 - (EF - YZ)^2.

 Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF,
 and has a shorthand (that is, it can be represented as some "#XYZ"

 Example 1:
 Input: color = "#09f166"
 Output: "#11ee66"
 Explanation:
 The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 This is the highest among any shorthand color.
 Note:

 color is a string of length 7.
 color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 Any answer which has the same (highest) similarity as the best answer will be accepted.
 All inputs and outputs should use lowercase letters, and the output is 7 characters.
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=1; i<color.length(); i+=2){
            helper(color.charAt(i), color.charAt(i+1), sb);
        }
        return sb.toString();
    }

    private void helper(char c1, char c2, StringBuilder sb){
        int d1 = Character.isDigit(c1) ? c1-'0' : 10+c1-'a';
        int d2 = Character.isDigit(c2) ? c2-'0' : 10+c2-'a';
        int sum = d1*16+d2;
        int idx = sum/17;
        int rem = sum % 17;
        if (rem > 8){
            idx++;
        }
        char c = idx<=9 ? (char)(idx+'0') : (char)('a'+idx-10);
        sb.append(c).append(c);
    }
}
