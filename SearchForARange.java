public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return searchRange(A, 0, A.length-1, target);
    }
    public int[] searchRange(int[] A, int lp, int rp, int target) {
        int [] result = {-1, -1};
        while (lp <= rp) {
            int medium = (lp + rp) / 2;
            if (A[medium] == target) {
                result[0] = medium;
                result[1] = medium;
                int [] temp1 = searchRange(A, lp, medium-1, target);
                int [] temp2 = searchRange(A, medium+1, rp, target);
                result[0] = temp1[0] == -1? result[0]:Math.min(temp1[0], result[0]);
                result[0] = temp2[0] == -1? result[0]:Math.min(temp2[0], result[0]);
                result[1] = temp1[1] == -1? result[1]:Math.max(temp1[1], result[1]);
                result[1] = temp2[1] == -1? result[1]:Math.max(temp2[1], result[1]);
                return result;
            }
            else if (A[medium] < target)
                lp = medium+1;
                else rp = medium-1;
        }
        return result;
    }
}
