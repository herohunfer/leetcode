public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0) return 0;
        boolean flag = true;
        if (!(x == Math.abs(x))) {
            flag = false;
            x = Math.abs(x);
        }
        String s = ""+x;
        String r = "";
        for (int i = s.length()-1; i >= 0; i--) {
            if (r.length() == 0 && s.charAt(i) == '0') continue;
            r += s.charAt(i);
        }
        if (flag) return Integer.parseInt(r);
        else return -1*Integer.parseInt(r);
    }
}
