public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combination(result, n, k, 0, new ArrayList<Integer>());
        return result;
    }
    public void combination(ArrayList<ArrayList<Integer>> result,
    int n, int k, int level, ArrayList<Integer> a) { 
        ArrayList<Integer> current = new ArrayList<Integer>(a);
        for (int i = level+1; i < n-k+2; i++) {
            current.add(i);
            if (k == 1) 
                result.add(new ArrayList<Integer>(current));
            else {
                combination(result, n, k-1, i, current);
            }
            current.remove(current.size()-1);
        }
    }
}

