// much easier solution. Check Wiki.
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n);i++)
            result.add((i >> 1) ^ i);
        return result;
    }
}


//previous solution:

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        result.add(0);
        if (n == 0) return result;
        result.add(1);
        if (n == 1) return result;
        result.add(3);
        result.add(2);
        if (n == 2) return result;
        int current = 2;
        boolean flag = false;
        for (int i = 4; i < Math.pow(2, n); i = i*2) {
            al.add(i);
            current+=i;
            if (flag) {
                result.add(current);
                    result.add(current+1);
                    result.add(current+3);
                    result.add(current+2);
                    current+=2;
            }
            else {
                    result.add(current);
                    result.add(current+1);
                    result.add(current-1);
                    result.add(current-2);
                    current-=2;
            }
            flag = !flag;
            
            for (int j = al.size()-2; j >= 0; j--) {
                int now = al.get(j);
                now = -now;
                al.add(now);
                current+=now;
                if (flag) {
                    result.add(current);
                    result.add(current+1);
                    result.add(current+3);
                    result.add(current+2);
                    current+=2;
                }
                else {
                    result.add(current);
                    result.add(current+1);
                    result.add(current-1);
                    result.add(current-2);
                    current-=2;
                }
                flag = !flag;
            }
        }
        return result;
    }
}
