public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j] != elem) {
                A[i++] = A[j];
            }
            j++;
        }
        return i;
    }
}
