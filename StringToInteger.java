public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long c = 1;
        int mul = 10;
        long result = 0;
        int pos = 0;
        //check if s == ""
        if (str.length() == 0) return 0;
        
        //get rid of spaces
        while (str.charAt(pos) == ' ') pos++;
        if (pos == str.length()) return 0;
        str = str.substring(pos);
        
        if (str.charAt(0) == '-') c = -1;
        else if (str.charAt(0) == '+') c = 1;
        else {
            if (str.charAt(0) <= '9' && str.charAt(0) >= '0') {
                result += str.charAt(0) - '0';
            }
            else return 0;
        }
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                if (str.charAt(i) == '0' && result == 0) 
                    continue;
                result *= mul;
                result += str.charAt(i) - '0';
                if (c*result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if (c*result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            else return (int)(c*result);
        }
        return (int)(c*result);
    }
}
