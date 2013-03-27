public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start.equals(end)) return 2;
        if (dict.isEmpty()) return 0;
        LinkedList<String> s = new LinkedList<String>();
        dict.add(end);
        s.add(start);
        int cpos = 0;
        int pos = s.size()-1;
        int steps = 2;
        while (cpos < s.size()) {
            String temp = s.get(cpos);
            for (int i = 0; i < temp.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String t = temp.substring(0,i)+ c + temp.substring(i+1);
                    if (dict.contains(t)) {
                        if (end.equals(t)) return steps;
                        dict.remove(t);
                        s.add(t);
                    }
                }
            }
            cpos++;
            if (cpos > pos) {steps++; pos = s.size()-1;}
        }
        return 0;
    }
}
