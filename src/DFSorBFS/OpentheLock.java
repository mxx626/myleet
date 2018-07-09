package DFSorBFS;
// BFS
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock
 DescriptionHintsSubmissionsDiscussSolution
 You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and
 wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move
 consists of turning one wheel one slot.

 The lock initially starts at '0000', a string representing the state of the 4 wheels.

 You are given a list of deadends dead ends, meaning if the lock displays any of these
 codes, the wheels of the lock will stop turning and you will be unable to open it.

 Given a target representing the value of the wheels that will unlock the lock, return
 the minimum total number of turns required to open the lock, or -1 if it is impossible.

 Example 1:
 Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 Output: 6
 Explanation:
 A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 because the wheels of the lock become stuck after the display becomes the dead end "0102".
 Example 2:
 Input: deadends = ["8888"], target = "0009"
 Output: 1
 Explanation:
 We can turn the last wheel in reverse to move from "0000" -> "0009".
 Example 3:
 Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 Output: -1
 Explanation:
 We can't reach the target without getting stuck.
 Example 4:
 Input: deadends = ["0000"], target = "8888"
 Output: -1
 Note:
 The length of deadends will be in the range [1, 500].
 target will not be in the list deadends.
 Every string in deadends and the string target will be a string of 4 digits from the 10,000
 possibilities '0000' to '9999'.

 */
public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) set.add(deadend);
        if (set.contains("0000")) return -1;
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int k=0; k<size; ++k){
                String open = queue.poll();
                char[] tmp = open.toCharArray();
                for (int i=0; i<4; ++i){
                    char replace = tmp[i];

                    tmp[i] = replace=='0' ? '9' : (char)((replace-'0'-1)+'0');
                    String trans1 = new String(tmp);
                    if (target.equals(trans1)) return step;
                    if (set.add(trans1)) queue.offer(trans1);

                    tmp[i] = replace=='9' ? '0' : (char)((replace-'0'+1)+'0');
                    String trans2 = new String(tmp);
                    if (target.equals(trans2)) return step;
                    if (set.add(trans2)) queue.offer(trans2);

                    tmp[i] = replace;
                }
            }
        }
        return -1;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    public int openLock2(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        HashSet<String> set = new HashSet<>();
        for (String str : deadends){
            set.add(str);
        }
        if (set.contains("0000")) return -1;
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> tmp = new HashSet<>();
        startSet.add("0000");
        endSet.add(target);
        int count=0;
        while (!startSet.isEmpty()&&!endSet.isEmpty()){
            if(startSet.size()>endSet.size()){
                tmp = startSet;
                startSet=endSet;
                endSet=tmp;
            }
            tmp = new HashSet<>();
            for (String string : startSet){
                if (set.contains(string)) continue;
                if (endSet.contains(string)) return count;
                set.add(string);
                for (int i=0; i<4; ++i){
                    String str1 = modify(string, i, 1);
                    String str2 = modify(string, i, -1);
                    if (!set.contains(str1)){
                        tmp.add(str1);
                    }
                    if (!set.contains(str2)){
                        tmp.add(str2);
                    }
                }

            }
            count++;
            startSet=tmp;
        }
        return -1;
    }
    private String modify (String string, int idx, int delta){
        char[] ch = string.toCharArray();
        if (delta==1){
            if (ch[idx]!='9'){
                ch[idx]= (char) (ch[idx]+1);
            }
            else ch[idx]='0';
        }
        else if (delta==-1){
            if (ch[idx]!='0'){
                ch[idx]=(char)(ch[idx]-1);
            }
            else ch[idx]='9';
        }
        return new String(ch);
    }
}
