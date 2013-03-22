// Hashmap is wonderful. Check if contains same character set first.
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() != s2.length()) return false;
        return check(s1, s2);
    }
    public boolean check(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) 
                map.put(c, map.get(c)+1);
            else map.put(c, 1); 
        }   
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) 
                map.put(c, map.get(c)-1);
            else return false;
        }   
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue().intValue();
            if (val != 0) return false; 
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String left_s1 = s1.substring(0, i);
            String right_s1 = s1.substring(i);
            String left_s2 = s2.substring(0, i);
            String right_s2 = s2.substring(i);
            if (check(left_s1, left_s2)&&check(right_s1, right_s2)) return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            String left_s1 = s1.substring(0, i);
            String right_s1 = s1.substring(i);
            String left_s2 = s2.substring(0, s1.length()-i);
            String right_s2 = s2.substring(s1.length()-i);
            if (check(left_s1, right_s2)&&check(right_s1, left_s2)) return true;
        }
        return false;
    }
}
