// folow other's solution. 
public class Solution {
   public int trap(int[] A) {
       // Start typing your Java solution below
       // DO NOT write main() function
       int max = 0;
       if (A.length == 0) return 0;
       for (int i = 0; i < A.length; i++) {
           if (A[max] < A[i]) max = i;
       }
       return trap(A, 0, max) + trap(A, max, A.length-1);
   }

   
public int trap(int[] A, int lp, int rp) {
       if (lp == rp) return 0;
       int max =  0;
       int total = 0;
       if (A[lp] == A[rp]) {
           total = A[lp]*(rp-lp-1);
           int i = lp+1;
           while (i < rp) {
               total -= A[i];
               i++;
           }
           return total;
       }
       else if (A[lp] > A[rp]) {
           //find local maximum from lp+1 to rp
           max = lp+1;
           for (int i = lp+1; i <= rp; i++) {
               if (A[max] < A[i]) max = i;
           }
           return  (A[max]*(max-lp-1) - calculate(A, lp, max) + trap(A, max, rp));
       }
       else {
           //find local maximum from lp+1 to rp
           max = rp-1;
           for (int i = 0; i <= rp-1; i++) {
               if (A[max] < A[i]) max = i;
           }
           return  (A[max]*(rp-max-1) - calculate(A, max, rp) + trap(A, lp, max));
       }
       
   }
   public int calculate(int [] A, int lp, int rp) {
       int cost = 0;
       for (int i = lp+1; i < rp; i++)
           cost += A[i];
       return cost;
   }
}
