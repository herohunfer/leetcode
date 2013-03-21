// actually we dont need hashmap. This array is already sorted, so a counter and a variable is enough.

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int offset = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1);
            else map.put(A[i],1);
            if (map.get(A[i]) > 2) {
                offset++;
            }
            else A[i-offset] = A[i];
        }
        return (A.length-offset);
    }
}
