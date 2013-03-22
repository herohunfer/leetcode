public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = m-1; i >= 0; i--) {
            A[i+n] = A[i];
        }
        int Apos = n;
        int Bpos = 0;
        int pos = 0;
        while (pos < m+n) {
            if (Apos == m+n) {
                while (Bpos < n) {
                    A[pos] = B[Bpos];
                    pos++;
                    Bpos++;
                }
                break;
            }
            else if (Bpos == n) {
                break;
            }
            else {
                if (A[Apos] < B[Bpos]) {
                    A[pos] = A[Apos];
                    pos++;
                    Apos++;
                }
                else {
                    A[pos] = B[Bpos];
                    pos++;
                    Bpos++;
                }
            }
        }
    }
}
