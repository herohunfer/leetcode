public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][] A = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(A[i], 0);
        int count=1, state = 0;
        int i=0, j=0;
        while (count <= n*n) {
            if (A[i][j] == 0) {
                A[i][j] = count;
                count++;
            }
            switch(state) {
                case 0:
                    if (j+1<n && A[i][j+1] == 0)
                        j++;
                    else state = 1;
                    break;
                    
                case 1:
                    if (i+1<n && A[i+1][j] == 0)
                        i++;
                    else state = 2;
                    break;
                case 2:
                    if (j-1>=0 && A[i][j-1] == 0)
                        j--;
                    else state = 3;
                    break;
                case 3:
                    if (i-1<n && A[i-1][j] == 0)
                        i--;
                    else state = 0;
                    break;
                default:
                    break;
            }
        }
        return A;
    }
}
