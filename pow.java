// rase something to native factor is the hard part
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) return (-1*(Math.abs(n) % 2 - 0.5)*2);
        double result = 1;
        boolean sign = true;
        if (n < 0) {
            sign = false;
            n = -n;
        }
        while (n>0) {
            result *= x;
            n--;
            if (result == 0.0) break;
        }
        if (!sign) result = 1.0/result;
        return result;
    }
}
