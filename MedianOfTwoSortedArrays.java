public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0 && B.length == 0) return 0;
        else if (A.length == 0) {
            if (B.length % 2 == 0) return (B[B.length/2-1]+B[B.length/2])/2.0;
            else return (B[B.length/2]);
        }
        else if (B.length == 0) {
            if (A.length % 2 == 0) return (A[A.length/2-1]+A[A.length/2])/2.0;
            else return (A[A.length/2]);
        }
        //normal case
        double result = 0.0;
        if ((A.length + B.length) % 2 == 1) {
            int p = 0;
            int q = 0;
            while (p+q <= (A.length+B.length) / 2) {
                if (p < A.length && q < B.length) {
                    if (A[p] < B[q]) {result = A[p]; p++; }
                    else {result = B[q]; q++;}
                }
                else if (p < A.length) {
                    p = (A.length + B.length)/2 - q + 1;
                    result = A[p-1];
                }
                else {
                    q = (A.length + B.length) /2 - p + 1;
                    result = B[q-1];
                }
            }
            return result;
        }
        else {
            int p = 0;
            int q = 0;
            while (p+q <= (A.length+B.length) /2 -1) {
                if (p < A.length && q < B.length) {
                    if (A[p] < B[q]) {result = A[p]; p++; }
                    else {result = B[q]; q++;}
                }
                else if (p < A.length) {
                    p = (A.length + B.length)/2 - q;
                    result = A[p-1];
                }
                else {
                    q = (A.length + B.length) /2 - p;
                    result = B[q-1];
                }
            }
            if (p < A.length && q < B.length) {
                if (A[p] < B[q]) {return (result + A[p]) / 2.0;}
                else {return (result + B[q]) / 2.0;}
            }
            else if (p < A.length) {
                return (result+A[p]) / 2.0;
            }
            else return (result+B[q]) / 2.0;
        }
    }
}
