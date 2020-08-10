package dynamic;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int j=0;
        for(int i=0;i<lenT;i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            if(j>=lenS){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
    }
}
