public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maximum = 0;
        int lp = 0;
        int rp = height.length-1;
        int val = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int local = lp;
            for (int j = lp; j <= rp; j++) {
                if (height[j] < height[local] && height[j] > val) {
                    local = j;
                }
            }
            val = height[local];
            if (local == lp) {
                if (maximum < height[local]*(rp-lp))
                    maximum = height[local]*(rp-lp);
                lp++;
            }
            else if (local == rp) {
                if (maximum < height[local]*(rp-lp))
                    maximum = height[local]*(rp-lp);
                rp--;
            }
            else {
                if (maximum < height[local]*(rp-local))
                    maximum = height[local]*(rp-local);
                    
                if (maximum < height[local]*(local-lp))
                    maximum = height[local]*(local-lp);
            }
            
            if (lp >= rp) break;
        }
        if (maximum < 0) maximum = 0;
        return maximum;
    }
}
