// fail at large case. need switch to array.
public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] s = new String [n];
        String ini = "";
        for (int i = 0; i < n; i++)
            ini += ".";
        Arrays.fill(s, ini);
        return solveNQueens(n, s, 0, n);
     }
    
NQueens 2

     public int solveNQueens(int n, String[] pass_s, 
        int result, int count) {
        String [] s = new String[n];
        
        int j = count-1;
            for (int i = 0; i < n; i++)
            if (pass_s[j].charAt(i) == '.') {
                //reset
                for (int k = 0; k < n; k++) {
                    s[k] = pass_s[k];
                }
                
                //begin add boundary
                s[j] = s[j].substring(0, i) + 'Q' + s[j].substring(i+1);
                for (int k = 0; k < n; k++) {
                    if (k != j)
                        //s[k].charAt(i) = 'K';
                        s[k] = s[k].substring(0, i) + 'K' + s[k].substring(i+1);
                    if (k != i)
                        //s[j].charAt(k) = 'K';
                        s[j] = s[j].substring(0, k) + 'K' + s[j].substring(k+1);
                    //if ((k!=0) && (i+k < n) && (j+k < n))
                        //s[j+k].charAt(i+k) = 'K';
                    //    s[j+k] = s[j+k].substring(0, i+k) + 'K' + s[j+k].substring(i+k+1);
                    if ((k!=0) && (i-k > -1) && (j-k > -1))
                        //s[j-k].charAt(i-k) = 'K';
                        s[j-k] = s[j-k].substring(0, i-k) + 'K' + s[j-k].substring(i-k+1);
                    if ((k!=0) && (i+k < n) && (j-k > -1))
                        //s[j-k].charAt(i+k) = 'K';
                        s[j-k] = s[j-k].substring(0, i+k) + 'K' + s[j-k].substring(i+k+1);
                    //if ((k!=0) && (i-k > -1) && (j+k < n))
                        //s[j+k].charAt(i-k) = 'K';
                     //   s[j+k] = s[j+k].substring(0, i-k) + 'K' + s[j+k].substring(i-k+1);
                }
                if (count == 1) {
                    for (int k = 0; k < n; k++)
                            s[k] = s[k].replace('K', '.');
                        result++;
                }
                else result = solveNQueens(n,s,result, count-1);
            }
            return result;
    }
}
