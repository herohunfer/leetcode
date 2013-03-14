//Notice 0.5 is not a good solution. a good approximate may be +1-1.0/1e10
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double result = 1;
        if (m <= 0 || n <= 0) return 0;
        m--;
        n--;
        for (int i = n+m; i> 0 && i > m; i--) {
            result *= i;
            result /= i-m;
        }
        //for (int i = 2; i <= n; i++) {
        //    result /= i;
        //}
        return (int)(result+0.5);
    }
}
