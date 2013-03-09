public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp = 0;
        int rp = s.length()-1;
        boolean flag = true;
        while (lp < rp) {
            if (!((s.charAt(lp) >= 'a' && s.charAt(lp) <= 'z') ||
               (s.charAt(lp) >= 'A' && s.charAt(lp) <= 'Z') ||
               (s.charAt(lp) >= '0' && s.charAt(lp) <= '9'))) {
                   lp++;
                   continue;
               }
            if (!((s.charAt(rp) >= 'a' && s.charAt(rp) <= 'z') ||
               (s.charAt(rp) >= 'A' && s.charAt(rp) <= 'Z') ||
               (s.charAt(rp) >= '0' && s.charAt(rp) <= '9'))) {
                   rp--;
                   continue;
               }
               
            if (s.charAt(lp) == s.charAt(rp) ||
                s.charAt(lp) - 'a' == s.charAt(rp) - 'A' ||
                s.charAt(lp) - 'A' == s.charAt(rp) - 'a') {
                    lp++;
                    rp--;
                }
            else {
                flag = false; 
                break;
                
            }
        }
        if (lp >= rp) return true;
        else return false;
    }
}

