public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pos = 0;
        while (pos + needle.length() <= haystack.length()) {
            if (haystack.substring(pos, pos+needle.length()).equals(needle))
                return haystack.substring(pos);
            pos++;
        }
        return null;
    }
}
