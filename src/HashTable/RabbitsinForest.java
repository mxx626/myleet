package HashTable;
import java.util.Arrays;
public class RabbitsinForest {
    /**
     * In a forest, each rabbit has some color. Some subset of rabbits
     * (possibly all of them) tell you how many other rabbits have the
     * same color as them. Those answers are placed in an array.

     Return the minimum number of rabbits that could be in the forest.

     Examples:
     Input: answers = [1, 1, 2]
     Output: 5
     Explanation:
     The two rabbits that answered "1" could both be the same color, say red.
     The rabbit than answered "2" can't be red or the answers would be inconsistent.
     Say the rabbit that answered "2" was blue.
     Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
     The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

     Input: answers = [10, 10, 10]
     Output: 11

     Input: answers = []
     Output: 0
     Note:

     answers will have length at most 1000.
     Each answers[i] will be an integer in the range [0, 999].
     * @param answers
     * @return
     */
    public int numRabbits3(int[] answers) {
        int count = 0;
        int[] map = new int[1000];

        for (int n : answers){
            if (map[n] == 0 || map[n] >= n + 1){
                map[n] = 1;
                count += n + 1;
            }else{
                map[n]++;
            }
        }
        return count;
    }
    ////////////////////////////////////////////////////////
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int count=0, sum=0, cur=1;
        for (int i=0; i<answers.length; ++i){
            if (answers[i]==0) {
                sum++;
                continue;
            }
            if (i==0){
                count = 1+answers[i];
                cur=1;
            }
            else {
                if (answers[i]==answers[i-1]){
                    cur++;
                    if (cur==count){
                        sum+=count;
                    }
                    else if (cur>count){
                        count = 1+answers[i];
                        cur=1;
                    }
                }
                else {
                    if (cur!=count) sum+=count;
                    count=1+answers[i];
                    cur=1;
                }
            }
        }
        int last = cur<count ? count : 0;
        return sum+last;
    }
}
