public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp = 0;
        int rp = height.length-1;
        int maximum = 0;
        while (lp < rp) {
            int local = Math.min(height[lp],height[rp]);
            if (maximum < local * (rp-lp)) maximum = local * (rp-lp);
            
            if (local == height[lp]) {
                while (lp < rp && height[lp] <= local)
                    lp++;
            }
            else {
                while (lp < rp && height[rp] <= local)
                    rp--;
            }
        }
        return maximum;
    }
}
