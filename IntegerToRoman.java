public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char [] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int mul = 0;
        String result = "";
        while (num > 0) {
            int c = num % 10;
            if (c == 9) result = roman[mul] + (roman[mul+2] + result);
            else if (c >= 5 && c < 9) {
                c -= 5;
                while (c > 0) {
                    result = roman[mul] + result;
                    --c;
                }
                result = roman[mul+1] + result;
            }
            else if (c == 4) result = roman[mul] + (roman[mul+1] + result);
            else while (c > 0) {
                result = roman[mul] + result;
                --c;
            }
            mul+=2;
            num /= 10;
        }
        return result;
    }
}
