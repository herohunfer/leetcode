public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
                if (A[i-1] > 0) {
                    A[i] += A[i-1];
                }
                if (A[i] > max) max = A[i];
        }
        return max;
    }
}
