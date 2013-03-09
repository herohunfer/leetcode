import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String [] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean [] map = new boolean [26];
        Arrays.fill(map, true);
        ArrayList<Character> queue = new ArrayList<Character>();
        int maximum = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("S[i]="+s.charAt(i));
            if (!map[s.charAt(i) - 'a']) {
                while (queue.get(0) != s.charAt(i)) {
                    map[queue.remove(0) - 'a'] = true;
                }
                queue.remove(0);
            }
            else map[s.charAt(i) - 'a'] = false;
            queue.add(s.charAt(i));
            maximum = (maximum < queue.size())?queue.size():maximum;
        }
        return maximum;
    }
}
