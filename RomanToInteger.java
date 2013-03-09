public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char [] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int level = 6, temp = 0, temp2 = 1000;
        int result = 0;
        int topLevel = 6;  //var to check against CIM
        int repeating = 0; //var to check aginast MDCCCCX; should be MCMX
        boolean dec = false;
        for (int i = 0; i < s.length(); i++) {
            int cLevel = checkLevel(roman, s.charAt(i));
            
            if (cLevel < 0) return 0;
            
            if (level == cLevel) {
                repeating++;
                if (repeating > 3) return 0;
                result += temp2;
                temp += temp2;
                
            } 
            else if (level < cLevel) {
                if (cLevel > topLevel) return 0; //against CIM case
                
                int j = 0;
                int c = 1;
                while (j < cLevel/2) { j++; c*=10;}
                if (cLevel % 2 == 1) c*=5;
                result += c - 2*temp;
                temp = 0;
                level = cLevel;
                topLevel = cLevel - 1;
                temp2 = c;
                repeating = 3; //same level cannot happen again. against MCMM
            }
            else //level > cLevel 
            {
                int j = 0;
                int c = 1;
                while (j < cLevel/2) { j++; c*=10;}
                if (cLevel % 2 == 1) {
                    c*=5;
                    repeating = 3; //half cannot happen again.
                }
                else repeating = 1;
                result += c;
                temp = c;
                temp2 = c;
                level = cLevel;
                
            }
        }
        return result;
    }
    public int checkLevel(char [] roman, char x) {
        for (int i = 0; i < roman.length; i++) {
            if (roman[i] == x) return i;
        }
        return -1;
    }
}
