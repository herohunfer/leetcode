public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++)
        {
            if (num[i] > target && best < Integer.MAX_VALUE) break;
            int temp = twoSumClosest(num, target-num[i], i);
            //pruning. target = best
            if (temp+num[i] == target) {
                best = target; 
                break;
                
            }
            if (best == Integer.MAX_VALUE)
                best = temp + num[i];
            else if (Math.abs(target-temp-num[i]) < Math.abs(target-best))
                best = temp + num[i];
            while (i+1 < num.length && num[i+1] == num[i]) {
                i++;
            }
        }
        return best;
    }
    public int twoSumClosest(int[] num, int target, int i) {
        int lp = i+1;
        int rp = num.length -1;
        int best = Integer.MAX_VALUE;
        if (lp < rp) best = num[lp]+ num[rp];
        while (lp < rp) {
            int sum = num[lp] + num[rp];
            if (sum == target) return target;
            int val = Math.abs(target - sum);
            if (val < Math.abs(target - best)) best = sum;
            if (sum < target) lp++;
            else rp--;
        }
        return best;
    }
}
