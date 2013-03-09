public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pivot = 0;
        while (pivot < A.length-1) {
            if (A[pivot] > A[pivot+1]) break;
            pivot++;
        }
        pivot = (pivot + 1) % A.length;
        int relative_lp = 0;
        int relative_rp = A.length-1;
        while (relative_lp <= relative_rp) {
            int medium = (relative_lp + relative_rp) / 2;
            if (A[(medium+pivot) % A.length] == target)
                return (medium+pivot) % A.length;
            else if (A[(medium+pivot) % A.length] < target)
                relative_lp = medium + 1;
                else relative_rp = medium - 1;
        }
        return -1;
    }
}
