public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s = "1";
        n--;
        while (n > 0) {
            int pos = 0;
            String r = "";
            while (pos < s.length()) {
                int count = 1;
                while (pos < (s.length()-1) && s.charAt(pos) == s.charAt(pos+1)) {
                    pos++;
                    count++;
                }
                r += (""+ count)+s.charAt(pos);
                pos++;
            }
            s = new String(r);
            n--;
        }
        return s;
    }
}

