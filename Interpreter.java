import java.util.*;
public class Interpreter {
    public static void main(String[] args) {
        // Start typing your code here...
        int [] height = {1,1};
        System.out.println(maxArea(height));
        
    }
    public static int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maximum = 0;
        int lp = 0;
        int rp = height.length-1;
        for (int i = 0; i < height.length; i++) {
            int local = Integer.MAX_VALUE;
            for (int j = lp; j <= rp; j++) {
                if (height[j] < height[local]) local = j;
            }
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
        return maximum;
    }
}
