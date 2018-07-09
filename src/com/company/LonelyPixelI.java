package com.company;
// TAG: Arrays, DFS
public class LonelyPixelI {
    /**
     * Given a picture consisting of black and white pixels, find the number of black lonely pixels.

     The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and
     white pixels respectively.

     A black lonely pixel is character 'B' that located at a specific position where the same row and
     same column don't have any other black pixels.

     Example:
     Input:
     [['W', 'W', 'B'],
     ['W', 'B', 'W'],
     ['B', 'W', 'W']]

     Output: 3
     Explanation: All the three 'B's are black lonely pixels.
     Note:
     The range of width and height of the input 2D array is [1,500].
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int res=0;
        for (int i=0; i<picture.length; ++i){
            int tmp = count(picture[i]);
            if (tmp!=-1){
                int count=0;
                for (int j=0; j<picture.length; ++j){
                    if (picture[j][tmp]=='B')
                        count++;
                }
                if (count==1) res++;
            }
        }
        return res;
    }

    private int count (char[] line){
        int count=0, idx=0;
        for (int i=0; i<line.length; ++i){
            if (line[i]=='B'){
                idx=i;
                count++;
            }
        }
        return count==1 ? idx : -1;
    }
}
