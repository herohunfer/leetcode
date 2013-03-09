public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> s = new ArrayList<String>();
        for (String a : strs) {
            s = permutation(a, "", s);
        }
        return s;
    }
    public ArrayList<String> permutation(String a, String b, ArrayList<String> s) {
        if (a.length() == 0) { 
            s.add(b); 
            return s;
        } 
        else
        {
            for (int i = 0; i < a.length(); i++) {
                s = permutation(a.substring(0,i) + a.substring(i+1), b + a.charAt(i), s);
            }
            return s;
        }
    }
}
