public class Solution {
    public int inc(int [] num, int index) {
        int newindex = index+1;
        while (newindex < num.length && num[index] == num[newindex]) {
            newindex++;
        }
        return newindex;
    }
    public int dec(int [] num, int index) {
        int newindex = index-1;
        while (newindex >= 0 && num[index] == num[newindex]) {
            newindex--;
        }
        return newindex;
        
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) return result;
        Arrays.sort(num);
        
        
        for (int i = 0; i < num.length-3; i = inc(num, i)) {
            for (int j = i+1; j < num.length-2; j = inc(num, j)) {
                int lp = j+1;
                int rp = num.length-1;
                while (lp < rp) {
                    if (num[i]+num[j]+num[lp]+num[rp] == target) {
                        ArrayList<Integer> a = new ArrayList<Integer>(3);
                        a.add(num[i]);
                        a.add(num[j]);
                        a.add(num[lp]);
                        a.add(num[rp]);
                        result.add(a);
                        lp = inc(num, lp);
                        rp = dec(num, rp);
                    }
                    else if (num[i]+num[j]+num[lp]+num[rp] < target)
                        lp = inc(num, lp);
                    else rp = dec(num, rp);
                }
            }
        }
        return result;
        
    }
}
