// almost the same as subsets I. one weird problem is that ArrayList.contains actually compare the content of the arraylist element, not the pointer. It invokes ArrayList equals method, which can be the reason why it can successfully compare the content of the arraylist.
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length <= 0) return result;
        Arrays.sort(num);
        for (int i = 0; i <= num.length; i++)
            pick(result, new ArrayList<Integer>(), num, -1, i); 
        return result;
    }
    
    public void pick(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> now,
                        int [] S, int limit, int level) {
        if (level == 0 && !result.contains(now)) {result.add(new ArrayList<Integer>(now));return;}
        for (int i = limit+1; i < S.length; i++) {
            now.add(S[i]);
            pick(result, now, S, i, level-1);
            now.remove(now.size()-1);
        }   
    }
}
