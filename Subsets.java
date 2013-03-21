public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S.length <= 0) return result;
        Arrays.sort(S);
        for (int i = 0; i <= S.length; i++)
            pick(result, new ArrayList<Integer>(), S, -1, i);
        return result;
    }
    public void pick(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> now,
                        int [] S, int limit, int level) {
        if (level == 0) result.add(new ArrayList<Integer>(now));
        for (int i = limit+1; i < S.length; i++) {
            now.add(S[i]);
            pick(result, now, S, i, level-1);
            now.remove(now.size()-1);
        }
    }
}
