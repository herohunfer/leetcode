public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] copyStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            copyStrs[i] = strs[i];
        }
        //sort each string
        for (int i = 0; i < strs.length; i ++) {
            char[] chars = copyStrs[i].toCharArray();
            Arrays.sort(chars);
            copyStrs[i] = new String(chars);
        }
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        for (String i : copyStrs) {
            if (m.containsKey(i)) m.put(i, m.get(i)+1);
            else m.put(i,1);
        }
        for (int i = 0; i < strs.length; i++) {
            if (m.get(copyStrs[i]) > 1) {
                result.add(strs[i]);
            }
        }
        return result;
    }
}
