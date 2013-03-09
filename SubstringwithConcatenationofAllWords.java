public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String i: L) 
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        
        
        if (L.length == 0) return result;
        int l = L[0].length();
        int pos = 0;
        Arrays.sort(L);
        while (pos+l*(L.length) <= S.length()) {
            HashMap<String, Integer> m = new HashMap<String, Integer>(map);
            int count = 0;
            int p = pos;
            boolean flag = true;
            while (count < L.length) {
                String sub = S.substring(p, p+l);
                if (m.get(sub) == null || m.get(sub) == 0) {
                    flag = false;
                    break;
                }
                else {
                    m.put(sub, m.get(sub)-1);
                    p += l; 
                    count++;
                    
                }
            }
            
            if (flag) result.add(pos);
            pos++;
        }
        return result;
    }
}
