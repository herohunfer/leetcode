public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int temp = 0;
        for (int i = 0; i < num.length; i++)
        {
            for (int j = i+1; j < num.length; j++)
                if (num[i] > num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
        }
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int [] s = new int [3];
        int total = 0;
        int current = -1;
        int i = 0;
        Arrays.fill(s, 0);
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        
        if (num.length == 0) return a;
        
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
            else {
                //check if current number will work
                /*if (current == 0)
                {
                */
                    if (i < 2) {s[i] = current; total += num[current]; ++i;}
                    else if (num[current] + total == 0) {
                            //bingo one answer
                            ArrayList<Integer> b = new ArrayList<Integer>();
                            int c = num[s[0]]*num[s[1]]*num[current];
                            int d = Math.abs(num[s[0]]*100) 
                            + Math.abs(num[s[1]]*10)
                            + Math.abs(num[current]);
                            if (c < 0) d *= -1;
                            if (!m.containsKey(d))
                            {
                                b.add(num[s[0]]);
                                b.add(num[s[1]]);
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
