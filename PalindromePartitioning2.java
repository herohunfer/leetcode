//add pruning.
public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, Integer> map 
        = new HashMap<String, Integer>();
        return (part(s, map));    
    }
    
  public int part(String s, HashMap<String, Integer> map) {
    //System.out.println(s);
    if (s.length() == 0) return 0;
    
    if (map.containsKey(s)) return map.get(s);
    
    int minimum = Integer.MAX_VALUE;
    if (s.length() == 1 || (new StringBuffer(s).reverse().toString().equals(s))) {
        map.put(s, 0);
        return 0;
    }
    for (int i = s.length()-1; i > 0; i--) {
      String first = s.substring(0, i);
      String second = s.substring(i);
      if (first.length() == 1 || (new StringBuffer(first).reverse().toString().equals(first))) {
        int second_result = part(second, map);
        if (second_result == 0) {
            map.put(s, 1);
            return 1;
        }
        if (minimum > second_result+1)
            minimum = second_result+1;
      }
    }
    map.put(s, minimum);
    return minimum;
  }
}
