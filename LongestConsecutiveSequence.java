public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> front = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> end = new HashMap<Integer, Integer>();
        HashSet<Integer> filter = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (filter.contains(num[i])) continue;
            else filter.add(num[i]);
            if (end.containsKey(num[i]-1) && front.containsKey(num[i]+1)) {
                front.put(end.get(num[i]-1), front.get(num[i]+1));
                end.put(front.get(num[i]+1), end.get(num[i]-1));
                front.remove(num[i]+1);
                end.remove(num[i]-1);
            }
            else if (end.containsKey(num[i]-1)) {
                front.put(end.get(num[i]-1), num[i]);
                end.put(num[i], end.get(num[i]-1));
                end.remove(num[i]-1);
            }
            else if (front.containsKey(num[i]+1)) {
                end.put(front.get(num[i]+1), num[i]);
                front.put(num[i], front.get(num[i]+1));
                front.remove(num[i]+1);
            }
            else {
                front.put(num[i], num[i]);
                end.put(num[i], num[i]);
            }
            //System.out.println(num[i]+":");
            for (Map.Entry<Integer, Integer> entry: front.entrySet()) {
              //System.out.println(entry.getKey()+" "+entry.getValue());
            }
            //System.out.println("end:"+num[i]);
        }
        int maximum = 0;
        for (Map.Entry<Integer, Integer> entry: front.entrySet()) {
            int left = entry.getKey().intValue();
            int right = entry.getValue().intValue();
            if (right-left+1 > maximum) maximum = right-left+1;
        }
        return maximum;
     }
}
