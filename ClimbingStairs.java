public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] a = new int [n];
        if (n < 3) return (n < 0)? 0:n;
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }
}
