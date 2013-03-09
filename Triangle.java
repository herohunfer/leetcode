public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (triangle.size() == 0) return 0;
        ArrayList<Integer> num = new ArrayList(triangle.get(triangle.size()-1));
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (num.get(j) < num.get(j+1))
                    num.set(j, num.get(j)+triangle.get(i).get(j));
                else num.set(j, num.get(j+1)+triangle.get(i).get(j));
            }
        }
        return num.get(0);
        
    }
}
