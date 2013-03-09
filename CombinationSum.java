public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i: candidates) {
            if (!m.containsKey(i)) {
                count++;
                m.put(i, 1);
            }
        }
        int [] c = new int [count];
        Arrays.sort(candidates);
        count = 0;
        for (int i = 0; i < candidates.length-1; i++) {
            if (candidates[i] != candidates[i+1]) {
                c[count] = candidates[i];
                count++;
            }
        }
        c[count] = candidates[candidates.length-1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combination(result, c, 0, new ArrayList<Integer>(), target);
        return result;
    }
    public void combination(ArrayList<ArrayList<Integer>> result, 
                                            int[] c, int p, ArrayList<Integer> current, int target) {
        //ArrayList<Integer> a = new ArrayList<Integer>();
        
        if (p > c.length-1) return;
        
        ArrayList<Integer> original = new ArrayList<Integer>(current);
        
        for (int i = 1; i <= target / c[p]; i++) {
            original.add(c[p]);
            if (target - c[p]*i == 0) {
                result.add(new ArrayList<Integer>(original));
            }
            else combination(result, c, p+1, original, target- c[p]*i);
        }
        combination(result, c, p+1, current, target);
    }
}
