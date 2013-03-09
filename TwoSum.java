public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (numbers.length < 2) return null;
        int [] two = new int [2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    two[0] = i+1;
                    two[1] = j+1;
                    return two;
                }
            }
        }
        return two;
    }
}
