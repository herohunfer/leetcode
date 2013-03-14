//nasty.
// test: 
// 0.1e1        true
// 0.1e0.1      false
// +.           false
// -.           false
// +2.          true
// e9           false
// "  123  2 "  false
// .34e2        true
// ++1          false
public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        boolean eflag = false;
        boolean dashflag = false;
        boolean dotflag = false;
        boolean flag = false;
        boolean requireNum = false;
        boolean once = false;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '.')
                if (!dotflag && !eflag && !requireNum) {
                    dotflag = true;
                }
                else return false;
            else if (c == 'e')
                if (eflag || !flag)
                    return false;
                else {flag = false; dashflag = false; dotflag = false; eflag = true;
                    requireNum = true;
                }
            else if (c == '-' || c == '+')
                if (dotflag || dashflag || flag) return false;
                else {dashflag = true;}
            else if (c >= '0' && c <= '9') {
                flag = true;
                once = true;
            }
            else return false;
            
            i++;
        }
        if (!once || (!flag && !(dotflag && !requireNum))) return false;
        else return true;
    }
}
