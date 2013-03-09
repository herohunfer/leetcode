// very interesting prunning method. 
public class Solution {
   public int jump(int[] A) {
       // Start typing your Java solution below
       // DO NOT write main() function
       if (A.length == 0) return 0;
       int [] steps = new int [A.length];
       steps[0] = 0;
       int limit = 0;
       for (int i = 0; i < A.length-1; i++) {
           if (A[i]+i > limit) {
               if (A[i] + i >= A.length-1) return steps[i]+1;
               else
               {
                   for (int j = limit+1; j <= i+A[i]; j++)
                       steps[j] = steps[i]+1;
                   limit = i+A[i];
               }
           }
       }
       return steps[A.length-1];
   }
}
