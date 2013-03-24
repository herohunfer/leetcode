public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length()+s2.length() != s3.length()) return false;
        return interleave(s1, 0, s2, 0, s3, 0);
    }
    public boolean interleave(String s1, int s1_pos, String s2, int s2_pos, String s3, int s3_pos) {
        boolean flag = false;
        while ((s1_pos < s1.length() || s2_pos < s2.length())){
            if (!((s1_pos < s1.length() && s1.charAt(s1_pos) == s3.charAt(s3_pos))
                || (s2_pos < s2.length() && s2.charAt(s2_pos) == s3.charAt(s3_pos))))
                return false;
            
            while (
                (s1_pos < s1.length() && s1.charAt(s1_pos) == s3.charAt(s3_pos)) 
                && (s2_pos >= s2.length() || s2.charAt(s2_pos) != s3.charAt(s3_pos))) {
                    s1_pos++;
                    s3_pos++;
                }
            while (
                (s2_pos < s2.length() && s2.charAt(s2_pos) == s3.charAt(s3_pos)) 
                && (s1_pos >= s1.length() || s1.charAt(s1_pos) != s3.charAt(s3_pos))) {
                    s2_pos++;
                    s3_pos++;
               }
            if (s1_pos < s1.length() && s2_pos < s2.length()
                && s1.charAt(s1_pos) == s3.charAt(s3_pos) && s2.charAt(s2_pos) == s3.charAt(s3_pos)) {
                    flag = true;
                    break;
                }
        }
        if (flag) return (interleave(s1, s1_pos+1, s2, s2_pos, s3, s3_pos+1)
                            || interleave(s1, s1_pos, s2, s2_pos+1, s3, s3_pos+1));
        else return true;
    }
}
