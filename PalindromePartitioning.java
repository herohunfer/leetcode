// hashset has no use here.
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    HashMap<String, HashSet<ArrayList<String>>> map 
      = new HashMap<String, HashSet<ArrayList<String>>>();
    return new ArrayList<ArrayList<String>>(part(s, map));
  }
  public HashSet<ArrayList<String>> part(String s, HashMap<String, HashSet<ArrayList<String>>> map) {
    //System.out.println(s);
    if (s.length() == 0) return new HashSet<ArrayList<String>>();
    
    if (map.containsKey(s)) return map.get(s);
    HashSet<ArrayList<String>> result = new HashSet<ArrayList<String>>();
    if (s.length() == 1 || (new StringBuffer(s).reverse().toString().equals(s))) {
        ArrayList<String> now = new ArrayList<String>();
        now.add(s);
        result.add(now);
    }
    for (int i = 1; i < s.length(); i++) {
      String first = s.substring(0, i);
      String second = s.substring(i);
      if (first.length() == 1 || (new StringBuffer(first).reverse().toString().equals(first))) {
        HashSet<ArrayList<String>> second_result = part(second, map);
        ArrayList<ArrayList<String>> second_al = new ArrayList<ArrayList<String>>(second_result);
      
        for (ArrayList<String> sec: second_al) {
          ArrayList<String> now = new ArrayList<String>(sec);
          now.add(0, first);
          result.add(now);
        }
      }
    }
    map.put(s, result);
    return result;
  }
}


