package String;
// TAG: String
public class SimplifyPath {
    /**
     *
     * @param path
     * @return
     */
    // Beat 100%
    public String simplifyPath2(String path) {
        String[] res = new String[path.length()];
        char[] ch = path.toCharArray();
        int start=0, end=0, idx=0;
        while (end<ch.length){
            start=end;
            if (ch[end]=='/'){
                end++;
                continue;
            }
            while (end<ch.length && ch[end]!='/') end++;
            String cur = path.substring(start, end);
            if (cur.equals(".")) continue;
            else if (cur.equals("..")){
                if (idx==0) continue;
                else idx--;
            }
            else {
                res[idx++]=cur;
            }
            end++;
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i=0; i<idx; ++i){
            if (i==0){
                sb.append(res[i]);
                continue;
            }
            sb.append("/"+res[i]);
        }
        return sb.toString();
    }



    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        String[] res = new String[paths.length];
        int start=0;
        for (int i=0; i<paths.length; ++i){
            if (paths[i].length()==0) continue;
            if (paths[i].equals("..")){
                if (start==0) continue;
                else start--;
            }
            else if (paths[i].equals(".")) continue;
            else {
                res[start++]=paths[i];
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i=0; i<start; ++i){
            if (i==0) {
                sb.append(res[i]);
                continue;
            }
            sb.append("/"+res[i]);
            //         System.out.println(res[i]);
        }
        return sb.toString();
    }
}
