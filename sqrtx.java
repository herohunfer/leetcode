public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long i = x/2;
        long j = x;
        while (i*i > x) {
            j = i;
            i /= 2;
        }
        for (long k = i; k <= j; k++) {
            if (k*k <= x && (k+1)*(k+1)>x) return (int)k;
        }
        return -1;
    }
}
