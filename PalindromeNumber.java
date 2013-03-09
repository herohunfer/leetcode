public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return false;
        if (x < 10) return true;
        int mul = 10;
        int mul2 = 1;
        while (x / mul > 9) mul*=10;
        while (mul > mul2) {
            if (x/mul%10 == x/mul2%10) {
                mul  /= 10;
                mul2 *= 10;
            }
            else return false;
        }
        return true;
    }
}
