// Use 2-dimentional array to store the possible variable and its number
// for example [1 1 2 3 3 3 4]
// c =  0 1 2 3
//   0 [1 2 3 4]
//   1 [2 1 3 1]
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i: num) {
            if (!m.containsKey(i)) {
                count++;
                m.put(i,1);
            }
        }
        int [][] c = new int [count][2];
        Arrays.sort(num);
        count = 0;
        c[count][0] = num[0];
        c[count][1] = 1;
        for (int i = 0; i < num.length-1; i++) {
            if (num[i] != num[i+1]) {
                count++;
                c[count][0] = num[i+1];
                c[count][1]++;
            }
            else ++c[count][1];
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combination(result, c, 0, new ArrayList<Integer>(), target);
        return result;
    }
     public void combination(ArrayList<ArrayList<Integer>> result, 
                int[][] c, int p, ArrayList<Integer> current, int target) {
        //ArrayList<Integer> a = new ArrayList<Integer>();
        
        if (p > c.length-1) return;
        
        ArrayList<Integer> original = new ArrayList<Integer>(current);
        for (int i = 1; i <= c[p][1] && target-c[p][0]*i >= 0; i++) {
            //choose
            original.add(c[p][0]);
            if (target - c[p][0]*i == 0) {
                result.add(new ArrayList<Integer>(original));
            }
            else combination(result, c, p+1, original, target- c[p][0]*i);
            
        }
        //dont choose
        combination(result, c, p+1, current, target);
    }
}
