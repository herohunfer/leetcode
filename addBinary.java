public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0;
        int carry = 0;
        String c = "";
        if (a.length() < b.length()) 
        {
            l = b.length();
            char [] fill = new char [b.length() - a.length()];
            Arrays.fill(fill, '0');
            String zeros = new String(fill);
            a = zeros + a;
        }
        else 
        {
            l = a.length();
            char [] fill = new char [a.length() - b.length()];
            Arrays.fill(fill, '0');
            String zeros = new String(fill);
            b = zeros + b;
        }
        
        for (int i = l-1; i >= 0; i--) {
            int result = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            carry = result / 2;
            c = result % 2 + "" + c;
        }
        if (carry != 0) c = carry + c;
        return c;
    }
}
