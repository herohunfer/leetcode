public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < obstacleGrid.length; i++)
            for (int j = 0; j < obstacleGrid[0].length; j++)
            if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        map.put(0, 1);
        while (!map.isEmpty()) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
                int pos = entry.getKey();
                int val = entry.getValue();
                int i = pos / 100;
                int j = pos % 100;
                obstacleGrid[i][j] = val;
                if (i <obstacleGrid.length-1 && obstacleGrid[i+1][j] == 0 && !map.containsKey(100*(i+1)+j))
                    if (map2.containsKey(100*(i+1)+j))
                        map2.put(100*(i+1)+j, map2.get(100*(i+1)+j)+val);
                    else map2.put(100*(i+1)+j, val);
                if (j <obstacleGrid[0].length-1 && obstacleGrid[i][j+1] == 0 && !map.containsKey(100*i+j+1))
                    if (map2.containsKey(100*i+j+1))
                        map2.put(100*i+j+1, map2.get(100*i+j+1)+val);
                    else map2.put(100*i+j+1, val);
            }
            map = new HashMap<Integer, Integer>(map2);
            map2.clear();
        }
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]<0) return 0;
        else return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
