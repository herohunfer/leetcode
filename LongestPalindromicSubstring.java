public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            int p = i-1;
            int q = i+1;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (max.length() < 2*(i-1-p)+1) {
                max = s.substring(p+1, q);
            }
            p = i;
            q = i+1;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (max.length() < 2*(i-p)) {
                max = s.substring(p+1, q);
            }
        }
        return max;
    }
}
