public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean firstcolumn = false;
        boolean firstrow = false;
        
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == 0) {
                firstrow = true;
                break;
            }
        for (int i = 0; i < matrix[0].length; i++)
            if (matrix[0][i] == 0) {
                firstcolumn = true;
                break;
            }
        for (int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        for (int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
        }
        if (firstrow) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstcolumn) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
