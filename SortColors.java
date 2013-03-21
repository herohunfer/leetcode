public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int red = Integer.MIN_VALUE, white = Integer.MIN_VALUE, blue = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (red >= 0) A[++red] = 0;
                else {A[0] = 0; red = 0; }
                if (white >= 0) A[++white] = 1;
                if (blue >= 0) A[++blue] = 2;
            }
            else if (A[i] == 1) {
                if (white >= 0) A[++white] = 1;
                else 
                    if (red >= 0) {white = red+1; A[white] = 1;}
                    else {white = 0; A[white] = 1;}
                if (blue >= 0) A[++blue] = 2;
            }
            else {
                blue = i;
            }
            //do nothing if A[i] == 2
        }
    }
}

