// hard problem. 
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        while (i < A.length) {
            if (A[i] != i+1 && A[i] >0 && A[i]<=A.length && A[i] != A[A[i]-1]) {
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
            }
            else i++;
        }
        for (i = 0; i< A.length; i++)
            if (A[i] != i+1) return (i+1);
            
        return A.length+1;
    }
}
