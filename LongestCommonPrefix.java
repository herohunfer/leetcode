public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length == 0 || strs[0].length() == 0) return "";
        int pos = 0;
        String a = strs[0].substring(0,1);
        while (pos < strs[0].length()) {
            for (int i = 0; i < strs.length; i++) {
                if (pos >= strs[i].length() 
                || !a.equals(strs[i].substring(0, pos+1))) return a.substring(0,a.length()-1);
            }
            pos++;
            if (pos < strs[0].length()) a += strs[0].charAt(pos);
        }
        return a;
    }
}
