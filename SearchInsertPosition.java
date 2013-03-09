public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp = 0;
        int rp = A.length-1;
        int cause = 0;
        while (lp <= rp) {
            int medium = (lp + rp) / 2;
            if (A[medium] == target)
                return medium;
            else if (A[medium] < target)
            {
                cause = 0;
                lp = medium + 1;
            }
            else {
                cause = 1;
                rp = medium - 1;
            }
        }
        if (cause == 1) return (rp+1);
        else return lp;
    }
}
