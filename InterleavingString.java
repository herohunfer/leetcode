// classic dp problem. Hard to think, easy to write!

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length()+s2.length() != s3.length()) return false;
        return interleave(s1, s2, s3);
    }
    public boolean interleave(String s1, String s2, String s3) {
        boolean [][] map = new boolean [s1.length()+1][s2.length()+1];
        
        map[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            map[i][0] = map[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int j = 1; j <= s2.length(); j++) {
            map[0][j] = map[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                map[i][j] = (map[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                            (map[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return map[s1.length()][s2.length()];
    }
}
