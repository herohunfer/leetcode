public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s = "";
        String t = "";
        if (n == 1) return "1";
        String result = "";
        int denominator = 1; 
        for (int i = 1; i <= n-1; i++) {
            s += i;
            denominator *= i;
        }
        t = s;
        k = k-1;
        for (int i = n-1; i > 0; i--) {
            int c = k / denominator;
            int r = k % denominator;
            result += s.charAt(c);
            if (c == 0) t = t.substring(c+1);
            else
                t = t.substring(0,c)+t.substring(c+1);
            k = r;
            denominator /= i;
        }
        result+=t;
        return result;
    }
}
