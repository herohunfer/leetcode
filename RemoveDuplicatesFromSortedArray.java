public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pos = 0;
        int count = 0;
        while (pos < A.length) {
            if (pos == A.length-1 || A[pos] != A[pos+1]) {
                count++;
                pos++;
            }
            else if (pos < A.length-1) {
                //int padding = 1;
                //while (pos+padding < A.length-1 && A[pos+padding] == A[pos+padding+1])
                //    padding++;
                for (int i = pos+1; i < A.length-1; i++)
                    A[i] = A[i+1];
                A = Arrays.copyOfRange(A, 0, A.length-1);
            }
        }
        return count;
    }
}
