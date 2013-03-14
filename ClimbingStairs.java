public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=1, j=2, k = 3;
        if (n <= 1) return 1;
        if (n == 2) return 2;
        while (n-2 > 0) {
            k = i+j;
            i = j;
            j = k;
            n--;
        }
        return k;
    }
}
