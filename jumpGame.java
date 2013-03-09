public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean [] can = new boolean [A.length];
        int limit = 0;
        Arrays.fill(can, false);
        can[0] = true;
        for (int i = 0; i < A.length-1; i++) {
            if (can[i]) {
                if (i+A[i] >= A.length-1) return true;
                for (int j = limit+1; j <= i+A[i]; j++) {
                    can[j] = true;
                }
                limit = Math.max(limit, i+A[i]);
            }
        }
        return can[A.length-1];
    }
    
}
