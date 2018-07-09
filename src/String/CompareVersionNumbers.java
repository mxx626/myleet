package String;
// TAG: String, Math
public class CompareVersionNumbers {
    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
     second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
     Credits:
     Special thanks to @ts for adding this problem and creating all test cases.
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int p1=0, p2=0;
        while (p1<version1.length() || p2<version2.length()){
            int val1=0, val2=0;
            while (p1<version1.length() && version1.charAt(p1)!='.'){
                val1 = val1*10 + (version1.charAt(p1)-'0');
                p1++;
            }
            while (p2<version2.length() && version2.charAt(p2)!='.'){
                val2 = val2*10 + (version2.charAt(p2)-'0');
                p2++;
            }
            if (val1>val2) return 1;
            else if (val1<val2) return -1;
            p1++;
            p2++;
        }
        return 0;
    }
        public int compareVersion2(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int len = Math.max(v1.length, v2.length);
            for (int i=0; i<len; ++i){
                Integer n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
                Integer n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
                if (n1.compareTo(n2)!=0){
                    return n1.compareTo(n2);
                }
            }
            return 0;
        }
}
