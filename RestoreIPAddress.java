public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        restore(s, 0, 4,new ArrayList<Integer>(4), result);
        return result;
    }   
    public void restore(String s, int limit, int remain, ArrayList<Integer> now, ArrayList<String> result) {
        if (remain == 1) {
            String sub = s.substring(limit);
            if (sub.startsWith("0") && !sub.equals("0")) return;
            if (Long.parseLong(sub) <= 255) {
              now.add(Integer.parseInt(sub));
              String str = ""; 
              for (int i : now) {
                  str+=i+".";
              }   
              str = str.substring(0, str.length()-1);
              if (!result.contains(str))
                result.add(str);
              now.remove(now.size()-1);
            }   
        }   
        else {
            for (int i = limit; i < s.length()-remain+1; i++) {
                if ((s.length()-i-1)/remain > 3) return;
                //System.out.println(s+" limit="+limit+" i="+i);
                String sub = s.substring(limit, i+1);
                if (sub.startsWith("0") && !sub.equals("0")) return;
                if (Long.parseLong(sub) <= 255) {
                    now.add(Integer.parseInt(sub));
                    restore(s, i+1, remain-1, now, result);
                    now.remove(now.size()-1);
                }   
            }   
        }   
    }
}
