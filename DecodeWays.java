//conside '0' situation.

public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0) return 0;
        if (s.length() == 1) if (s.charAt(0) == '0') return 0; 
                            else return 1;
        int first = 1;
        int second = 1;
        if (s.charAt(0) == '0') return 0;
        if (s.charAt(1) == '0') {if (s.charAt(0) > '2') return 0;}
        else if (Integer.parseInt(s.substring(0,2)) < 27) second = 2;
        
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) > '2' || s.charAt(i-1) == '0') return 0;
                second = first;
            }
            else {
                if (s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i-1, i+1)) < 27) {
                    int temp = first;
                    first = second;
                    second += temp;
                }
                else 
                    first = second;
            }
        }
        return second;
    }
}
