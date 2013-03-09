public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int temp = 0;
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int [] s = new int [4];
        int total = 0;
        int current = -1;
        int i = 0;
        Arrays.fill(s, 0);
        HashMap<Long, Integer> m = new HashMap<Long, Integer>();
        
        
        if (num.length < 4) return a;
        
        while (i!=-1) {
            //increase the current pointer
            ++current;
            if (current > num.length-1) {
                --i;
                if (i >= 0) 
                {
                    current = s[i];
                    total -= num[current];
                }
            }
            else if (total + num[current] > target || total + (4-i)*num[num.length-1] < target) {
                --i;
                if (i >= 0) 
                {
                    current = s[i];
                    total -= num[current];
                }
            }
            else {
                //check if current number will work
                /*if (current == 0)
                {
                */
                    if (i < 3) {s[i] = current; total += num[current]; ++i;}
                    else if (num[current] + total == target) {
                            //bingo one answer
                            ArrayList<Integer> b = new ArrayList<Integer>();
                            long c = num[s[0]]*num[s[1]]*num[s[2]]*num[current];
                            long d = Math.abs((long)num[s[0]]*1000000000) 
                            + Math.abs((long)num[s[1]]*1000000)
                            + Math.abs((long)num[s[2]]*1000)
                            + Math.abs((long)num[current]);
                            if (c < 0) d *= -1;
                            if (!m.containsKey(d))
                            {
                                b.add(num[s[0]]);
                                b.add(num[s[1]]);
                                b.add(num[s[2]]);
                                b.add(num[current]);
                                a.add(b);
                                m.put(d, 1);
                            }
                        }
                /*
                }       
                else if (num[current] != num[current-1])
                {
                    if (i < 2) {s[i] = current; total += num[current]; ++i;}
                    else if (num[current] + total == 0) {
                        //bingo one answer
                        ArrayList<Integer> b = new ArrayList<Integer>();
                        b.add(num[s[0]]);
                        b.add(num[s[1]]);
                        b.add(num[s[2]]);
                        a.add(b);
                    }
                }
                */
            }
        }
        return a;
    }
}
