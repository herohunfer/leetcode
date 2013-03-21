// i->row
// j->column
// [i][j]
//  |  |
//  |  ----------matrix[0]
//  -----matrix
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp = 0;
        int rp = matrix.length-1;
        int middle = 0;
        int current = 0;
        while (lp <= rp) {
            middle = (lp+rp)/2;
            if (matrix[middle][0] == target) return true;
            else if (matrix[middle][0] < target) { lp = middle+1;current = lp-1;}
            else {rp = middle-1;current = rp;}
        }
        if (current < 0 || current >= matrix.length) return false;
        lp = 0;
        rp = matrix[0].length-1;
        middle = 0;
        while (lp <= rp) {
            middle = (lp+rp)/2;
            if (matrix[current][middle] == target) return true;
            else if (matrix[current][middle] < target) lp = middle+1;
            else rp = middle-1;
        }
        return false;
        
    }
}
