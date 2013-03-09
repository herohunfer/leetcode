public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int total = 0;
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return total;
            else total++;
        }
        return total;
    }
}
