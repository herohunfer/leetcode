public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s = "1";
        if (n == 1) return "1";
        String result = "";
        int denominator = 1; 
        for (int i = 2; i <= n; i++) {
            s += i;
            denominator *= i-1;
        }
        k = k-1;
        for (int i = n-1; i > 0; i--) {
            int c = k / denominator;
            int r = k % denominator;
            result += s.charAt(c);
            if (c == 0) s = s.substring(c+1);
            else
                s = s.substring(0,c)+s.substring(c+1);
            k = r;
            denominator /= i;   
        }
        result+=s;
        return result;
    }
}
