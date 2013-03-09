public class Solution {
    public int isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String [][] A = new String [9][9];
        for (String [] array : A)
            Arrays.fill(array, "123456789");
            
        for (int i = 0; i< 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char c = board[i][j];
                    A[i][j] = "" + c;
                    for (int k = 0; k < 9; k++) {
                        if (k != j) {
                            A[i][k] = removeChar(A[i][k], c);
                            if (A[i][k].length() == 0)
                                return i+10*k;
                        }
                        if (k != i) {
                            A[k][j] = removeChar(A[k][j], c);
                            if (A[k][j].length() == 0)
                                return k+100*j;
                        }
                    }
                    for (int k = (i/3)*3; k < (i/3+1)*3; k++)
                        for (int f = (j/3)*3; f < (j/3+1)*3; f++)
                        if (k != i && f != j)
                        {
                            
                            A[k][f] = removeChar(A[k][f], c);
                            if (A[k][f].length() == 0)
                                return i+1000*j;
                        }
                }
            }
        }
        
        return 1;
    }
    public String removeChar(String s, char a) {
        int index = s.indexOf(a);
        String result = s;
        if (index != -1) {
            String s1 = (index == 0)? "":s.substring(0, index-1);
            String s2 = (index == s.length()-1)? "":s.substring(index+1);
            result = s1+s2;
        }
        return result;
    }
}
