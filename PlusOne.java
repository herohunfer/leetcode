//ignore negative case. much easier than I thought.
public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (digits.length == 0) return digits;
        int i = digits.length-1, carry = 1;
        if (digits[0] >= 0) {
            while (i >= 0) {
                digits[i] += carry;
                carry = digits[i]/10;
                digits[i]%=10;
                i--;
            }
            if (carry > 0) {
                int [] newdigits = new int [digits.length+1];
                newdigits[0] = carry;
                for (int j = 0; j < digits.length; j++) {
                    newdigits[j+1] = digits[j];
                }
                return newdigits;
            }
            else return digits;
        }
        else {
            while (i > 0) {
                digits[i] -= carry;
                if (digits[i] < 0) {
                    carry = 1;
                    digits[i] += 10;
                }
                else break;
            }
            if (i == 0 && carry == 1) digits[0]+=1; 
            return digits;
        }
    }
}
