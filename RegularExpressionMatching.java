public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = s.length()-1;
        int j = p.length()-1;
        boolean iFlag = false, jFlag = false, iGreat = false, jGreat = false;
        while (i >= 0 || j >=0) {
            if (i >= 0) {
                if (s.charAt(i) == '.' && iFlag) {
                    iGreat = true;
                    iFlag = false;
                    i--;
                }
                else if (s.charAt(i) == '.') {
                    iFlag = false;
                    i--;
                    j--;
                }
                else if (s.charAt(i) == '*') {
                    i--;
                    while (s.charAt(i) == p.charAt(j)) {
                        iFlag = true;
                        j--;
                    }
                    i--;
                }
            }
            if (j >= 0) {
                if (p.charAt(j) == '.' && jFlag) {
                    jGreat = true;
                    jFlag = false;
                    j--;
                }
            }
                
                
                
            }
        }
    }
}
