public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] A = new int [n+1];
        A[0] = 1;
        A[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                A[i] += A[j-1]*A[i-j];
                
            }
        }
        return A[n];
    }
}
