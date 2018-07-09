package String;
// String
public class StudentAttendanceRecordI {
    /**
     * ou are given a string representing an attendance record for a student.
     * The record only contains the following three characters:
     'A' : Absent.
     'L' : Late.
     'P' : Present.
     A student could be rewarded if his attendance record doesn't contain more
     than one 'A' (absent) or more than two continuous 'L' (late).

     You need to return whether the student could be rewarded according to his
     attendance record.

     Example 1:
     Input: "PPALLP"
     Output: True
     Example 2:
     Input: "PPALLL"
     Output: False
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int countA = 0;
        int countB = 0;
        for (char c : s.toCharArray()){
            if (c=='A'){
                countA++;
                countB=0;
            }
            else if (c=='L'){
                countB++;
            }
            else{
                countB=0;
            }
            if (countA==2 || countB==3) return false;
        }
        return true;
    }
}
