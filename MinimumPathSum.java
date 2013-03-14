public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][] sum = new int [grid.length][grid[0].length];
        for (int i = 0; i < sum.length; i++)
            Arrays.fill(sum[i], Integer.MAX_VALUE);
        sum[0][0] = grid[0][0];
        for (int i = 0; i < sum.length; i++)
            for (int j = 0; j < sum[0].length; j++) {
                if (i < sum.length-1 && sum[i+1][j] > sum[i][j]+grid[i+1][j])
                    sum[i+1][j] = grid[i+1][j]+sum[i][j];
                if (j < sum[0].length-1 && sum[i][j+1] > sum[i][j]+grid[i][j+1])
                    sum[i][j+1] = grid[i][j+1]+sum[i][j];
            }
        return sum[sum.length-1][sum[0].length-1];
    }
}
