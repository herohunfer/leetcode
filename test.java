import java.util.*;
public class test {
  public static void main(String [] args) {
    test t = new test();
    System.out.println(t.partition("dde"));

  }
  public ArrayList<ArrayList<String>> partition(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    HashMap<String, HashSet<ArrayList<String>>> map 
      = new HashMap<String, HashSet<ArrayList<String>>>();
    return new ArrayList<ArrayList<String>>(part(s, map));
  }
  public HashSet<ArrayList<String>> part(String s, HashMap<String, HashSet<ArrayList<String>>> map) {
    //System.out.println(s);
    if (map.containsKey(s)) return map.get(s);
    HashSet<ArrayList<String>> result = new HashSet<ArrayList<String>>();
    if (s.length() == 1 || (new StringBuffer(s).reverse().toString().equals(s))) {
      //System.out.println("good:"+s);
      ArrayList<String> now = new ArrayList<String>();
      now.add(s);
      if (!result.contains(now)) result.add(now);
    }
    for (int i = 1; i < s.length(); i++) {
      String first = s.substring(0, i);
      String second = s.substring(i);
      HashSet<ArrayList<String>> first_result = part(first, map);
      HashSet<ArrayList<String>> second_result = part(second, map);
      ArrayList<ArrayList<String>> first_al = new ArrayList<ArrayList<String>>(first_result);
      ArrayList<ArrayList<String>> second_al = new ArrayList<ArrayList<String>>(second_result);
      
      for (ArrayList<String> fir: first_al) {
        for (ArrayList<String> sec: second_al) {
          ArrayList<String> now = new ArrayList<String>(fir);
          now.addAll(sec);
          if (!result.contains(now)) result.add(now);
        }
      }
    }
    map.put(s, result);
    return result;
  }
}
