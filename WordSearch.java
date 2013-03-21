import java.util.*;

public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    HashSet<Integer> hs = new HashSet<Integer>();
                    hs.add(i*board[0].length+j);
                    if (check(board, word, 1, hs, i*board[0].length+j)) return true;
                }
            }
        return false;

    }
    public boolean check(char[][] board, String word, int level, HashSet<Integer> now, int a) {

        if (level == word.length()) return true;

        int i = a / board[0].length;
        int j = a % board[0].length;
        // left
        if (i >0 && !now.contains((i-1)*board[0].length+j) && board[i-1][j] == word.charAt(level)) {
            HashSet<Integer> next = new HashSet<Integer>(now);
            next.add((i-1)*board[0].length+j);
            if (check(board, word, level+1, next, (i-1)*board[0].length+j)) return true;
        }
        // right
        if (i < board.length-1 && !now.contains((i+1)*board[0].length+j) && board[i+1][j] == word.charAt(level)) {
            HashSet<Integer> next = new HashSet<Integer>(now);
            next.add((i+1)*board[0].length+j);
            if (check(board, word, level+1, next, (i+1)*board[0].length+j)) return true;

        }
        // up
        if (j >0 && !now.contains(i*board[0].length+j-1) && board[i][j-1] == word.charAt(level)) {
            HashSet<Integer> next = new HashSet<Integer>(now);
            next.add(i*board[0].length+j-1);
            if (check(board, word, level+1, next, i*board[0].length+j-1)) return true;
        }
        // down
        if (j < board[0].length-1 && !now.contains(i*board[0].length+j+1)&& board[i][j+1] == word.charAt(level)) {
            HashSet<Integer> next = new HashSet<Integer>(now);
            next.add(i*board[0].length+j+1);
            if (check(board, word, level+1, next, i*board[0].length+j+1)) return true;
        }

        return false;
    }
}
