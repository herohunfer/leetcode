public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.length() < T.length()) return 0;
        if (S.equals(T)) return 1;
        int pos = 0;
        int count = 0;
        while (pos <= S.length()-T.length()) {
            
            while (pos <= S.length()-T.length() && S.charAt(pos) != T.charAt(0)) 
                pos++;
            
            if (pos <= S.length()-T.length())
                if (T.length() == 1) ++count;
                else {
                    count += numDistinct(S.substring(pos+1), T.substring(1));
                }
            pos++;
        }
        return count;
    }
}
