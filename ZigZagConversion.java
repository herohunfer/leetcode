public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (nRows == 1) return s;
        String result = "";
        for (int i = 0; i < nRows; i++) {
            int p = i;
            int inc = nRows*2-2*i-2;
            if (i == nRows-1) inc = nRows*2-2;
            while (p < s.length()) {
                result += s.charAt(p);
                p += inc;
                if (inc != nRows*2-2) {
                    inc = nRows*2-2-inc;
                }
            }
        }
        return result;
    }
}
